package endafarrell.healthgraph4j;

import endafarrell.healthgraph4j.api.Feed;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.net.URI;

public class HealthGraph4JExample {

    public static void main(String[] args) throws HealthGraphException, ConfigurationException {

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

        // With the configuration, create a factory and then a new HealthGraph
        HealthGraphFactory factory = new HealthGraphFactory(configuration);
        HealthGraph healthGraph = factory.getInstance();

        // Get your profile
        Profile profile = healthGraph.getProfile();
        System.out.println(profile);
        System.out.println();

        Feed<FitnessActivityItem> fitnessActivityFeed = null;
        int num = 1;
        URI next = null;
        do {
            fitnessActivityFeed = healthGraph.getFitnessActivityFeed(next);
            for (FitnessActivityItem fitnessActivityItem : fitnessActivityFeed.getItems()) {
                FitnessActivitySummary fitnessActivitySummary =
                        healthGraph.getFitnessActivitySummary(fitnessActivityItem);
                System.out.println(String.format("%2d %s", num++, fitnessActivitySummary));
            }
            next = fitnessActivityFeed.getNext();
            System.out.println("fitnessActivityFeed.next = '" + next + "'");
        } while (next != null);
        System.out.println();

        num = 1;
        for (FitnessActivityItem fitnessActivityItem : healthGraph.getFitnessActivityItemList()) {
            FitnessActivity fitnessActivity = healthGraph.getFitnessActivity(fitnessActivityItem);
            System.out.println(String.format("%2d %s", num++, fitnessActivity));
        }
    }
}
