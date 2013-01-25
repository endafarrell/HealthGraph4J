package endafarrell.healthgraph4j;

import endafarrell.healthgraph4j.oauth.RunKeeperApi;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

import java.util.Scanner;

public class HealthGraphImpl implements HealthGraph {

    /*package*/ HealthGraphImpl(Configuration configuration) {
        Token EMPTY_TOKEN = null;

        // Add https proxy info here
        System.setProperty("https.proxyHost", "nokes.nokia.com");
        System.setProperty("https.proxyPort", "8080");

        OAuthService service = new ServiceBuilder()
                                   .provider(RunKeeperApi.class)
                                   .apiKey(configuration.getClientID())
                                   .apiSecret(configuration.getClientSecret())
                                   .callback("http://localhost:8080")
                                   .build();
        Scanner in = new Scanner(System.in);

        System.out.println("=== RunKeeperApi's OAuth Workflow ===");

        // Obtain the Authorization URL
        System.out.println("Fetching the Authorization URL...");
        String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
        System.out.println("Got the Authorization URL!");
        System.out.println("Now go and authorize Scribe here:");
        System.out.println(authorizationUrl);
        System.out.println("And paste the authorization code here");
        System.out.print(">>");
        Verifier verifier = new Verifier(in.nextLine());
        System.out.println();

        // Trade the Request Token and Verifier for the Access Token
        System.out.println("Trading the Request Token for an Access Token...");
        Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
        System.out.println("Got the Access Token!");
        System.out.println("(if your curious it looks like this: " + accessToken + " )");
        System.out.println();

        // Now let's go and ask for a protected resource!
        System.out.println("Now we're going to access a protected resource...");

        OAuthRequest userRequest = new OAuthRequest(Verb.GET, "https://api.runkeeper.com/user?oauth_token=" + accessToken.getToken());
        userRequest.addHeader("Accept",  HealthGraph.ContentType.USER);

        service.signRequest(accessToken, userRequest); // the access token from step 4
        System.out.println(userRequest);
        Response userResponse = userRequest.send();
        System.out.println(userResponse.getCode());
        System.out.println(userResponse.getBody());

        OAuthRequest fitnessActivitiesReqest = new OAuthRequest(Verb.GET, "https://api.runkeeper.com/fitnessActivities?oauth_token=" + accessToken.getToken());
        fitnessActivitiesReqest.addHeader("Accept", ContentType.FITNESS_ACTIVITY_FEED);

        service.signRequest(accessToken, fitnessActivitiesReqest); // the access token from step 4
        System.out.println(fitnessActivitiesReqest);
        Response fitnessActivitiesResponse = fitnessActivitiesReqest.send();
        System.out.println(fitnessActivitiesResponse.getCode());
        System.out.println(fitnessActivitiesResponse.getBody());
    }

    public String getUserID() throws HealthGraphException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Profile getProfile() throws HealthGraphException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Profile getProfile(int userId) throws HealthGraphException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public User getUser() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
