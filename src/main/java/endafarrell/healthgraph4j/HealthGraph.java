package endafarrell.healthgraph4j;

import endafarrell.healthgraph4j.api.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public interface HealthGraph extends
        UserResources,
        StrengthTrainingActivitiesResources,
        WeightResources,
        SettingsResources,
        DiabetesResources,
        TeamResources,
        SleepResources,
        FitnessActivitiesResources,
        NutritionResources,
        GeneralMeasurementsResources,
        BackgroundActivitiesResources,
        RecordsResources,
        ProfileResources
{
    DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("EEE, d MMM YYYY HH:mm:ss");

    String authenticate(AuthorisationMethod authorisationMethod) throws HealthGraphException;
    void authenticate(String authenticationCode) throws HealthGraphException;

    class ContentType {
        public static final String USER = "application/vnd.com.runkeeper.User+json";
        public static final String PROFILE = "application/vnd.com.runkeeper.Profile+json";
        public static final String FITNESS_ACTIVITY_FEED = "application/vnd.com.runkeeper.FitnessActivityFeed+json";
        public static final String FITNESS_ACTIVITY_SUMMARY = "application/vnd.com.runkeeper.FitnessActivitySummary+json";
        public static final String FITNESS_ACTIVITY = "application/vnd.com.runkeeper.FitnessActivity+json";

    }


    public enum AuthorisationMethod {
        CmdlineInteractive,
        OAuthCallback
    }
}
