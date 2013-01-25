package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.Configuration;

public class ConfigurationImpl implements Configuration {
    String clientID;
    String clientSecret;
    String authorizationURL;
    String accessTokenURL;
    String deAuthorizationURL;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(final String clientID) {
        this.clientID = clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(final String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getAuthorizationURL() {
        return authorizationURL;
    }

    public void setAuthorizationURL(final String authorizationURL) {
        this.authorizationURL = authorizationURL;
    }

    public String getAccessTokenURL() {
        return accessTokenURL;
    }

    public void setAccessTokenURL(final String accessTokenURL) {
        this.accessTokenURL = accessTokenURL;
    }

    public String getDeAuthorizationURL() {
        return deAuthorizationURL;
    }

    public void setDeAuthorizationURL(final String deAuthorizationURL) {
        this.deAuthorizationURL = deAuthorizationURL;
    }



}
