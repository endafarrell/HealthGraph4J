package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.Configuration;

public class ConfigurationImpl implements Configuration {

    String oauthConsumerKey;
    String oauthConsumerSecret;
    String oauthAccessToken;
    String oauthAccessTokenSecret;

    public String getOAuthConsumerKey() {
        return oauthConsumerKey;
    }

    public String getOAuthConsumerSecret() {
        return oauthConsumerSecret;
    }

    public String getOAuthAccessToken() {
        return oauthAccessToken;
    }

    public String getOAuthAccessTokenSecret() {
        return oauthAccessTokenSecret;
    }

    public void setOauthConsumerKey(String oauthConsumerKey) {
        this.oauthConsumerKey = oauthConsumerKey;
    }

    public void setOauthConsumerSecret(String oauthConsumerSecret) {
        this.oauthConsumerSecret = oauthConsumerSecret;
    }

    public void setOauthAccessToken(String oauthAccessToken) {
        this.oauthAccessToken = oauthAccessToken;
    }

    public void setOauthAccessTokenSecret(String oauthAccessTokenSecret) {
        this.oauthAccessTokenSecret = oauthAccessTokenSecret;
    }
}
