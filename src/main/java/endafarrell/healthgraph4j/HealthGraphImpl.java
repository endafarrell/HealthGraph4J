package endafarrell.healthgraph4j;

import endafarrell.healthgraph4j.oauth.RunKeeperApi;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.*;
import org.scribe.oauth.OAuthService;

import java.util.Scanner;

public class HealthGraphImpl implements HealthGraph {

    /*package*/ HealthGraphImpl(Configuration configuration) {
        Token EMPTY_TOKEN = null;

        String AUTHORIZE_URL = "https://runkeeper.com/apps/authorize";
        //To change body of created methods use File | Settings | File Templates.
        OAuthService service = new ServiceBuilder()
                                   .provider(RunKeeperApi.class)
                                   .apiKey("apiKey")
                                   .apiSecret("apiSecret")
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

        // Trade the Request Token and Verfier for the Access Token
        System.out.println("Trading the Request Token for an Access Token...");
        Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
        System.out.println("Got the Access Token!");
        System.out.println("(if your curious it looks like this: " + accessToken + " )");
        System.out.println();

        // Now let's go and ask for a protected resource!
        System.out.println("Now we're going to access a protected resource...");

        OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.runkeeper.com/user/");
        service.signRequest(accessToken, request); // the access token from step 4
        System.out.println(request);
        Response response = request.send();
        System.out.println(response.getCode());
        System.out.println(response.getBody());
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
