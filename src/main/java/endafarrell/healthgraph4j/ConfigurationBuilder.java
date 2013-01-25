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

    public ConfigurationBuilder setOauthAccessToken(String oauthAccessToken) {
        checkNotBuilt();
        configurationBean.setOauthAccessToken(oauthAccessToken);
        return this;
    }

    public ConfigurationBuilder setOauthAccessTokenSecret(String oauthAccessTokenSecret){
        checkNotBuilt();
        configurationBean.setOauthAccessTokenSecret(oauthAccessTokenSecret);
        return this;
    }

    public ConfigurationBuilder setOauthConsumerKey(String oauthConsumerKey){
        checkNotBuilt();
        configurationBean.setOauthConsumerKey(oauthConsumerKey);
        return this;
    }

    public ConfigurationBuilder setOauthConsumerSecret(String oauthConsumerSecret) {
        checkNotBuilt();
        configurationBean.setOauthConsumerSecret(oauthConsumerSecret);
        return this;
    }

}
