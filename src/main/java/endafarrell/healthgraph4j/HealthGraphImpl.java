package endafarrell.healthgraph4j;

import endafarrell.healthgraph4j.api.Feed;
import endafarrell.healthgraph4j.api.HealthGraphList;
import endafarrell.healthgraph4j.impl.*;
import endafarrell.healthgraph4j.oauth.RunKeeperApi;
import org.apache.commons.lang.NotImplementedException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

import java.io.IOException;
import java.net.URI;

import java.util.Scanner;

public class HealthGraphImpl implements HealthGraph {
    private static final int FEED_FIRST_PAGE = 0;
    private static final int FEED_ALL = -1;


    private transient Token accessToken;
    private final OAuthService authService;
    private final ObjectMapper mapper;
    private final User user;
    private final HealthGraphList<FitnessActivityItem> fitnessActivityItemList;
    private Profile profile;



    HealthGraphImpl(Configuration configuration) throws HealthGraphException {
        Token EMPTY_TOKEN = null;

        // Add https proxy info here
        //System.setProperty("https.proxyHost", "nokes.nokia.com");
        //System.setProperty("https.proxyPort", "8080");

        this.mapper = new ObjectMapper();
        this.authService = new ServiceBuilder()
                .provider(RunKeeperApi.class)
                .apiKey(configuration.getClientID())
                .apiSecret(configuration.getClientSecret())
                .callback("http://localhost:8080")
                .build();
        Scanner in = new Scanner(System.in);
        // Obtain the Authorization URL
        String authorizationUrl = authService.getAuthorizationUrl(EMPTY_TOKEN);
        System.out.println("Now go and authorize Scribe here:");
        System.out.println(authorizationUrl);
        System.out.println("And paste the authorization code here");
        System.out.print(">>");
        Verifier verifier = new Verifier(in.nextLine());
        System.out.println();

        // Trade the Request Token and Verifier for the Access Token
        this.accessToken = authService.getAccessToken(EMPTY_TOKEN, verifier);

        try {
            String responseBody = readService(ContentType.USER, USER_RESOURCES_PATH);
            this.user = mapper.readValue(responseBody, UserImpl.class);
        } catch (IOException e) {
            throw new HealthGraphException(e);
        }
        this.fitnessActivityItemList = new HealthGraphListImpl<FitnessActivityItem>(100);
    }



    private String readService(String contentType, URI uri) throws HealthGraphException {
        return readService(contentType, uri.toString());
    }

    public Profile getProfile() throws HealthGraphException {
        if (profile == null) {
            try {
                String responseBody = readService(ContentType.PROFILE, this.user.getProfileResourcesPath());
                profile = mapper.readValue(responseBody, ProfileImpl.class);
            } catch (IOException e) {
                throw new HealthGraphException(e);
            }
        }
        return profile;
    }

    public Profile getProfile(int userId) throws HealthGraphException {
        throw new NotImplementedException();
    }

    public User getUser() {
        return user;
    }

    public HealthGraphList<FitnessActivityItem> getFitnessActivityList() throws HealthGraphException {
        return getFitnessActivityListImpl(FEED_FIRST_PAGE);
    }

    public HealthGraphList<FitnessActivityItem> getFitnessActivityList(final boolean getAllFeedPages) throws HealthGraphException {
        return getFitnessActivityListImpl(getAllFeedPages ? FEED_ALL : FEED_FIRST_PAGE);
    }

    public HealthGraphList<FitnessActivityItem> getFitnessActivityList(int count) throws HealthGraphException {
        if (count < 1) throw new IllegalArgumentException("count must be at least one, call requested " + count);
        return getFitnessActivityListImpl(count);
    }

    public FitnessActivitySummary getFitnessActivitySummary(FitnessActivityItem fitnessActivityItem) throws HealthGraphException {
        // TODO - these can/should be cached, but it may make more sense to do this in the calling/using application
        // TODO - rather than in this library as one suspects the calling/using application will have some form of
        // TODO - database with the older ones.
        try {
            String responseBody = readService(ContentType.FITNESS_ACTIVITY_SUMMARY, fitnessActivityItem.getURI());
            return mapper.readValue(responseBody, FitnessActivitySummaryImpl.class);
        } catch (IOException e) {
            throw new HealthGraphException(e);
        }
    }

    public FitnessActivity getFitnessActivity(FitnessActivityItem fitnessActivityItem) throws HealthGraphException {
        // TODO - these can/should be cached, but it may make more sense to do this in the calling/using application
        // TODO - rather than in this library as one suspects the calling/using application will have some form of
        // TODO - database with the older ones.
        try {
            String responseBody = readService(ContentType.FITNESS_ACTIVITY, fitnessActivityItem.getURI());
            return mapper.readValue(responseBody, FitnessActivityImpl.class);
        } catch (IOException e) {
            throw new HealthGraphException(e);
        }
    }


    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    ////////////////////////////////////////////////////////////////////////////////////////////
    //\\\\\\          _       _                        _                 _              \\\\\\\\
    ////////         (_)     | |                      | |               | |             ////////
    //\\\\\\          _ _ __ | |_ ___ _ __ _ __   __ _| |   ___ ___   __| | ___         \\\\\\\\
    ////////         | | '_ \| __/ _ \ '__| '_ \ / _` | |  / __/ _ \ / _` |/ _ \        ////////
    //\\\\\\         | | | | | ||  __/ |  | | | | (_| | | | (_| (_) | (_| |  __/        \\\\\\\\
    ////////         |_|_| |_|\__\___|_|  |_| |_|\__,_|_|  \___\___/ \__,_|\___|        ////////
    //\\\\\\                                                                            \\\\\\\\
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    ////////////////////////////////////////////////////////////////////////////////////////////



    String readService(final String contentType, final String path) throws HealthGraphException {
        String serviceRoot = "https://api.runkeeper.com";

        OAuthRequest userRequest = new OAuthRequest(
                Verb.GET,
                serviceRoot + path);
        userRequest.addHeader("Accept", contentType);
        authService.signRequest(accessToken, userRequest);
        Response userResponse = userRequest.send();
        if (userResponse.isSuccessful()) {
            return userResponse.getBody();
        }
        throw new HealthGraphException(userRequest.toString() + " failed with response code" + userResponse.getCode()
                                               + " and returned the following content:\n" + userResponse.getBody());
    }

    HealthGraphList<FitnessActivityItem> getFitnessActivityListImpl(int count) throws HealthGraphException {
        // Remember: FEED_FIRST_PAGE == 0 and this is used when no count is specified. The use case us "Give me what
        // you already have". Thing is - at the start we have nothing and so the second test is a greater than.
        if (count == FEED_FIRST_PAGE && this.fitnessActivityItemList.size() > 0) {
            return new UnmodifiableHealthGraphListImpl<FitnessActivityItem>(this.fitnessActivityItemList);
        }

        // If we have enough to satisfy count (greater than 0) then sent that many
        if (count != FEED_ALL && this.fitnessActivityItemList.size() > count) {
            return new UnmodifiableHealthGraphListImpl<FitnessActivityItem>(
                    this.fitnessActivityItemList.subList(0, count),
                    fitnessActivityItemList.getHealthGraphSize());
        }

        // We need to go and get the feed page-by-page until we either hit the end or we have a big enough count.
        boolean done = false;
        String page = this.user.getFitnessActivityItemsResourcesPath();
        do {
            String responseBody = readService(ContentType.FITNESS_ACTIVITY_FEED, page);
            Feed<FitnessActivityItem> fitnessActivityItemsFeed =
                    jsonToObject(responseBody, new TypeReference<FeedImpl <FitnessActivityItemImpl>>() { });
            this.fitnessActivityItemList.addAll(fitnessActivityItemsFeed.getItems());
            this.fitnessActivityItemList.setHealthGraphSize(fitnessActivityItemsFeed.getSize());
            page = fitnessActivityItemsFeed.getNext();
            if (count == FEED_FIRST_PAGE) {
                done = true;
            }
            if (count != FEED_ALL && this.fitnessActivityItemList.size() >= count) {
                done = true;
            }
            if (fitnessActivityItemsFeed.getNext() == null) {
                done = true;
            }
        } while (! done);

        // Send back what was asked for.
        if (count == FEED_ALL) {
            return new UnmodifiableHealthGraphListImpl<FitnessActivityItem>(this.fitnessActivityItemList);
        } else {
            int healthGraphSize = fitnessActivityItemList.getHealthGraphSize();
            return new UnmodifiableHealthGraphListImpl<FitnessActivityItem>(
                    this.fitnessActivityItemList.subList(0, Math.min(count, healthGraphSize)),
                    healthGraphSize);
        }
    }

    <T> T jsonToObject(String json, TypeReference valueTypeRef) throws HealthGraphException {
        try {
            return mapper.readValue(json, valueTypeRef);
        } catch (IOException e) {
            throw new HealthGraphException("While converting the following line this exception occurred\n"
                + json, e);
        }
    }
}
