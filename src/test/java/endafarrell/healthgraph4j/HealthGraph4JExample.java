package endafarrell.healthgraph4j;

import endafarrell.healthgraph4j.api.Feed;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class HealthGraph4JExample {

    public static void main(String[] args) {
        try {
            // Read my own config files
            PropertiesConfiguration properties =
                    new PropertiesConfiguration("/var/data/endafarrell/healthgraph4j/config/healthgraph4j.properties");
            ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
            configurationBuilder.setClientID(properties.getString("ClientID"));
            configurationBuilder.setClientSecret(properties.getString("ClientSecret"));
            configurationBuilder.setAuthorizationURL(properties.getString("AuthorizationURL"));
            configurationBuilder.setAccessTokenURL(properties.getString("AccessTokenURL"));
            configurationBuilder.setDeAuthorizationURL(properties.getString("DeAuthorizationURL"));

            Configuration configuration = configurationBuilder.build();
            HealthGraphFactory factory = new HealthGraphFactory(configuration);
            HealthGraph healthGraph = factory.getInstance();

            try {
                Profile profile = healthGraph.getProfile();
                System.out.println(profile);
                System.out.println();
                Feed<FitnessActivityItem> fitnessActivityFeed = healthGraph.getFitnessActivityFeed();
                System.out.println(fitnessActivityFeed);
                System.out.println();

                FitnessActivitySummary fitnessActivitySummary = healthGraph.getFitnessActivitySummary(fitnessActivityFeed.getItems().get(0));
            } catch (HealthGraphException e) {
                e.printStackTrace();
            }
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }


    }
}
