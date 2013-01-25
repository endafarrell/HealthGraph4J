package endafarrell.healthgraph4j;

public interface Configuration {

    void setClientID(String clientID);
    String getClientID();

    void setClientSecret(String clientSecret);
    String getClientSecret();

    void setAuthorizationURL(String authorizationURL);
    String getAuthorizationURL();

    void setAccessTokenURL(String accessTokenURL);
    String getAccessTokenURL();

    void setDeAuthorizationURL(String deAuthorizationURL);
    String getDeAuthorizationURL();
}
