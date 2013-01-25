package endafarrell.healthgraph4j;

public class HealthGraph4JExample {

    public static void main(String[] args) {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOauthAccessToken("oauthaccesstoken");
        configurationBuilder.setOauthAccessTokenSecret("oauthaccesstokensecret");
        configurationBuilder.setOauthConsumerKey("consumerkey");
        configurationBuilder.setOauthConsumerSecret("consumersecret");
        Configuration configuration = configurationBuilder.build();
        HealthGraphFactory factory = new HealthGraphFactory(configuration);
        HealthGraph healthGraph = factory.getInstance();

        try {
            Profile profile = healthGraph.getProfile();
            System.out.println(profile);
        } catch (HealthGraphException e) {
            e.printStackTrace();
        }
    }
}
