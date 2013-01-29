package endafarrell.healthgraph4j;

import endafarrell.healthgraph4j.impl.ProfileImpl;
import endafarrell.healthgraph4j.impl.UserImpl;
import endafarrell.healthgraph4j.oauth.RunKeeperApi;
import org.codehaus.jackson.map.ObjectMapper;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

import java.io.IOException;
import java.util.Scanner;

public class HealthGraphImpl implements HealthGraph {
    private transient Token accessToken;
    private final OAuthService authService;
    private final ObjectMapper mapper;
    private final User user;
    private Profile profile;

    /*package*/ HealthGraphImpl(Configuration configuration) {
        Token EMPTY_TOKEN = null;

        // Add https proxy info here
        System.setProperty("https.proxyHost", "nokes.nokia.com");
        System.setProperty("https.proxyPort", "8080");

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


//        OAuthRequest fitnessActivitiesReqest = new OAuthRequest(Verb.GET, "https://api.runkeeper.com/fitnessActivities?oauth_token=" + accessToken.getToken());
//        fitnessActivitiesReqest.addHeader("Accept", ContentType.FITNESS_ACTIVITY_FEED);
//
//        authService.signRequest(accessToken, fitnessActivitiesReqest); // the access token from step 4
//        System.out.println(fitnessActivitiesReqest);
//        Response fitnessActivitiesResponse = fitnessActivitiesReqest.send();
//        System.out.println(fitnessActivitiesResponse.getCode());
//        System.out.println(fitnessActivitiesResponse.getBody());
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

    public long getUserID() throws HealthGraphException {
        return this.user.getUserID();
    }

    public Profile getProfile() throws HealthGraphException {
        if (this.profile == null) {
            try {
                String responseBody = readService(ContentType.PROFILE, this.user.getProfileResourcesPath());
                System.out.println(responseBody);
                this.profile = mapper.readValue(responseBody, ProfileImpl.class);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return profile;
    }

    public Profile getProfile(int userId) throws HealthGraphException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public User getUser() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
