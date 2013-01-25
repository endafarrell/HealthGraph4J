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

}
