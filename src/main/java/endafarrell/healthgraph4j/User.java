package endafarrell.healthgraph4j;

public interface User {
    String getStrengthTrainingActivitiesResourcesPath();
    String getWeightResourcesPath();
    String getSettingsResourcesPath();
    String getDiabetesResourcesPath();
    String getTeamResourcesPath();
    String getFitnessActivityItemsResourcesPath();
    String getNutritionResourcesPath();
    String getGeneralMeasurementsResourcesPath();
    String getBackgroundActivitiesResourcesPath();
    String getRecordsResourcesPath();
    String getProfileResourcesPath();
    String getSleepResourcesPath();
    long getUserID();
}
