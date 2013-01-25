package endafarrell.healthgraph4j;

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
            configurationBuilder.setDeAuthorizationURL(properties.getString("De-Authorization URL"));

            Configuration configuration = configurationBuilder.build();
            HealthGraphFactory factory = new HealthGraphFactory(configuration);
            HealthGraph healthGraph = factory.getInstance();

            try {
                Profile profile = healthGraph.getProfile();
                System.out.println(profile);
            } catch (HealthGraphException e) {
                e.printStackTrace();
            }
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }


    }
}
