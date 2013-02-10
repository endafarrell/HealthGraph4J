package endafarrell.healthgraph4j;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.field.MillisDurationField;
import org.joda.time.format.PeriodFormat;

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

        int num = 1;
        // iterate over all of your fitness activities (the "true" gets all activities, not just the first page)
        for (FitnessActivityItem fitnessActivityItem : healthGraph.getFitnessActivityList(true)) {
            //System.out.println(String.format("%2d %s", num++, healthGraph.getFitnessActivity(fitnessActivityItem)));
        }

        System.out.println();
        num = 1;
        // Now that we have _all_ of the activities, you can also iterate over the summaries
        for (FitnessActivityItem fitnessActivityItem : healthGraph.getFitnessActivityList()) {
            //System.out.println(String.format("%2d %s", num++, healthGraph.getFitnessActivitySummary(fitnessActivityItem)));
        }

        System.out.println();
        num = 1;
        DateTime now = DateTime.now();
        // Now that we have _all_ of the activities, see some details about the (up to) 10 most recent
        for (FitnessActivityItem fitnessActivityItem : healthGraph.getFitnessActivityList(10)) {
            FitnessActivitySummary fitnessActivitySummary =
                    healthGraph.getFitnessActivitySummary(fitnessActivityItem);
            DateTime start = fitnessActivitySummary.getStartTime();
            Duration faD = new Duration(1000 * (long) fitnessActivitySummary.getDuration());
            Duration sp = new Duration(start, now);
            System.out.println(String.format("%2d starting at %s %s %5.0f took %s and was %s since the previous/now",
                    num++, start, fitnessActivitySummary.getType(),
                    fitnessActivitySummary.getTotalDistance(),
                    PeriodFormat.getDefault().print(new Period(faD)),
                    PeriodFormat.getDefault().print(new Period(sp))));
            now = start;
        }

    }
}
