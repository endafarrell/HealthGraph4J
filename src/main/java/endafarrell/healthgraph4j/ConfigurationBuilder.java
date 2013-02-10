package endafarrell.healthgraph4j;

import endafarrell.healthgraph4j.impl.ConfigurationImpl;

public class ConfigurationBuilder {
    private ConfigurationImpl configurationBean = new ConfigurationImpl();
    private void checkNotBuilt() {
        if (configurationBean == null) {
            throw new IllegalStateException("build() was already been called");
        }
    }

    public Configuration build() {
        checkNotBuilt();
        try {
            return configurationBean;
        } finally {
            configurationBean = null;
        }
    }

    public ConfigurationBuilder setClientID(final String clientID) {
        checkNotBuilt();
        configurationBean.setClientID(clientID);
        return this;
    }

    public ConfigurationBuilder setClientSecret(final String clientSecret) {
        checkNotBuilt();
        configurationBean.setClientSecret(clientSecret);
        return this;
    }

    public ConfigurationBuilder setAuthorizationURL(final String authorizationURL) {
        checkNotBuilt();
        configurationBean.setAuthorizationURL(authorizationURL);
        return this;
    }

    public ConfigurationBuilder setAccessTokenURL(final String accessTokenURL) {
        checkNotBuilt();
        configurationBean.setAccessTokenURL(accessTokenURL);
        return this;
    }

    public ConfigurationBuilder setDeAuthorizationURL(final String deAuthorizationURL) {
        checkNotBuilt();
        configurationBean.setDeAuthorizationURL(deAuthorizationURL);
        return this;
    }

    public ConfigurationBuilder setCallbackURL(String callbackURL) {
        checkNotBuilt();
        configurationBean.setCallbackURL(callbackURL);
        return this;
    }

    public ConfigurationBuilder setHttpsProxyHost(String httpsProxyHost) {
        checkNotBuilt();
        configurationBean.setHttpsProxyHost(httpsProxyHost);
        return this;
    }

    public ConfigurationBuilder setHttpsProxyPort(String httpsProxyPort) {
        checkNotBuilt();
        configurationBean.setHttpsProxyPort(httpsProxyPort);
        return this;
    }
}
