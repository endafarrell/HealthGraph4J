package endafarrell.healthgraph4j;

import endafarrell.healthgraph4j.api.*;

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
    String getUserID() throws HealthGraphException;

    class ContentType {
        public static final String FITNESS_ACTIVITY_FEED = "application/vnd.com.runkeeper.FitnessActivityFeed+json";
        public static final String USER = "application/vnd.com.runkeeper.User+json";
    }

}
