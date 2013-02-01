package endafarrell.healthgraph4j;

import endafarrell.healthgraph4j.api.Feed;
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
    private transient Token accessToken;
    private final OAuthService authService;
    private final ObjectMapper mapper;
    private final User user;
    private Profile profile;
    private Feed<FitnessActivityItem> fitnessActivityItems;

    HealthGraphImpl(Configuration configuration) {
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
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    String readService(final String contentType, final String path) {
        String serviceRoot = "https://api.runkeeper.com";

        OAuthRequest userRequest = new OAuthRequest(
                Verb.GET,
                serviceRoot + path + "?oauth_token=" + accessToken.getToken());
        userRequest.addHeader("Accept", contentType);
        authService.signRequest(accessToken, userRequest);
        Response userResponse = userRequest.send();
        return userResponse.getBody();
    }
    private String readService(String contentType, URI uri) {
        return readService(contentType, uri.toString());
    }

    public Profile getProfile() throws HealthGraphException {
        if (profile == null) {
            try {
                String responseBody = readService(ContentType.PROFILE, this.user.getProfileResourcesPath());
                profile = mapper.readValue(responseBody, ProfileImpl.class);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
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

    public Feed<FitnessActivityItem> getFitnessActivityFeed() throws HealthGraphException {
        if (fitnessActivityItems == null) {
            try {
                String responseBody = readService(ContentType.FITNESS_ACTIVITY_FEED, this.user.getFitnessActivityItemsResourcesPath());
                fitnessActivityItems = mapper.readValue(responseBody, new TypeReference<FeedImpl<FitnessActivityItemImpl>>(){});
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return fitnessActivityItems;
    }

    public FitnessActivitySummary getFitnessActivitySummary(FitnessActivityItem fitnessActivityItem) {
        // TODO - these can/should be cached, but it may make more sense to do this in the calling/using application
        // TODO - rather than in this library as one suspects the calling/using application will have some form of
        // TODO - database with the older ones.
        try {
            String responseBody = readService(ContentType.FITNESS_ACTIVITY_SUMMARY, fitnessActivityItem.getURI());
            System.out.println(responseBody);
            FitnessActivitySummary fitnessActivitySummary = mapper.readValue(responseBody, FitnessActivitySummaryImpl.class);
            return fitnessActivitySummary;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public FitnessActivity getFitnessActivity(FitnessActivityItem fitnessActivityItem) {
        // TODO - these can/should be cached, but it may make more sense to do this in the calling/using application
        // TODO - rather than in this library as one suspects the calling/using application will have some form of
        // TODO - database with the older ones.
        try {
            String responseBody = readService(ContentType.FITNESS_ACTIVITY, fitnessActivityItem.getURI());
            System.out.println(responseBody);
            FitnessActivity fitnessActivity = mapper.readValue(responseBody, FitnessActivityImpl.class);
            return fitnessActivity;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
