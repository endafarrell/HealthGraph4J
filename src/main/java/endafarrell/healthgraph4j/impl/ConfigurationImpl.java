package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.Configuration;

public class ConfigurationImpl implements Configuration {
    String clientID;
    String clientSecret;
    String authorizationURL;
    String accessTokenURL;
    String deAuthorizationURL;
    String httpsProxyHost;
    String httpsProxyPort;
    String callbackURL;

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

    public void setHttpsProxyHost(String httpsProxyHost) {
        this.httpsProxyHost = httpsProxyHost;
    }

    public void setDeAuthorizationURL(final String deAuthorizationURL) {
        this.deAuthorizationURL = deAuthorizationURL;
    }

    public String getHttpsProxyHost() {
        return httpsProxyHost;
    }

    public void setHttpsProxyPort(String httpsProxyPort) {
        this.httpsProxyPort = httpsProxyPort;
    }

    public String getHttpsProxyPort() {
        return httpsProxyPort;
    }

    public boolean hasHttpsProxyInfo() {
        return (httpsProxyHost != null && httpsProxyPort != null);
    }

    public void setCallbackURL(String callbackURL) {
        this.callbackURL = callbackURL;
    }

    public String getCallbackURL() {
        return callbackURL;
    }
}
