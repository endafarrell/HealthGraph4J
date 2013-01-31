package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.User;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;


public class UserImpl implements User {



    @JsonCreator
    public UserImpl(@JsonProperty("strength_training_activities") final String strengthTrainingActivitiesResourcesPath,
                    @JsonProperty("weight") final String weightResourcesPath,
                    @JsonProperty("settings") final String settingsResourcesPath,
                    @JsonProperty("diabetes") final String diabetesResourcesPath,
                    @JsonProperty("team") final String teamResourcesPath,
                    @JsonProperty("sleep") final String sleepResourcesPath,
                    @JsonProperty("fitness_activities") final String fitnessActivitiesResourcesPath,
                    @JsonProperty("userID") final long userID,
                    @JsonProperty("nutrition") final String nutritionResourcesPath,
                    @JsonProperty("general_measurements") final String generalMeasurementsResourcesPath,
                    @JsonProperty("background_activities") final String backgroundActivitiesResourcesPath,
                    @JsonProperty("records") final String recordsResourcesPath,
                    @JsonProperty("profile")final String profileResourcesPath) {
        this.strengthTrainingActivitiesResourcesPath = strengthTrainingActivitiesResourcesPath;
        this.weightResourcesPath = weightResourcesPath;
        this.settingsResourcesPath = settingsResourcesPath;
        this.diabetesResourcesPath = diabetesResourcesPath;
        this.teamResourcesPath = teamResourcesPath;
        this.fitnessActivitiesResourcesPath = fitnessActivitiesResourcesPath;
        this.nutritionResourcesPath = nutritionResourcesPath;
        this.generalMeasurementsResourcesPath = generalMeasurementsResourcesPath;
        this.backgroundActivitiesResourcesPath = backgroundActivitiesResourcesPath;
        this.recordsResourcesPath = recordsResourcesPath;
        this.profileResourcesPath = profileResourcesPath;
        this.userID = userID;
        this.sleepResourcesPath = sleepResourcesPath;
    }

    @JsonProperty("strength_training_activities")
    private final String strengthTrainingActivitiesResourcesPath;

    @JsonProperty("weight")
    private final String weightResourcesPath;

    @JsonProperty("settings")
    private final String settingsResourcesPath;

    @JsonProperty("diabetes")
    private final String diabetesResourcesPath;

    @JsonProperty("team")
    private final String teamResourcesPath;

    @JsonProperty("fitness_activities")
    private final String fitnessActivitiesResourcesPath;

    @JsonProperty("nutrition")
    private final String nutritionResourcesPath;

    @JsonProperty("general_measurements")
    private final String generalMeasurementsResourcesPath;

    @JsonProperty("background_activities")
    private final String backgroundActivitiesResourcesPath;

    @JsonProperty("records")
    private final String recordsResourcesPath;

    @JsonProperty("profile")
    private final String profileResourcesPath;

    @JsonProperty("userID")
    private final long userID;

    @JsonProperty("sleep")
    private final String sleepResourcesPath;


    public String getStrengthTrainingActivitiesResourcesPath() {
        return strengthTrainingActivitiesResourcesPath;
    }

    public String getWeightResourcesPath() {
        return weightResourcesPath;
    }

    public String getSettingsResourcesPath() {
        return settingsResourcesPath;
    }

    public String getDiabetesResourcesPath() {
        return diabetesResourcesPath;
    }

    public String getTeamResourcesPath() {
        return teamResourcesPath;
    }

    public String getFitnessActivityItemsResourcesPath() {
        return fitnessActivitiesResourcesPath;
    }

    public String getNutritionResourcesPath() {
        return nutritionResourcesPath;
    }

    public String getGeneralMeasurementsResourcesPath() {
        return generalMeasurementsResourcesPath;
    }

    public String getBackgroundActivitiesResourcesPath() {
        return backgroundActivitiesResourcesPath;
    }

    public String getRecordsResourcesPath() {
        return recordsResourcesPath;
    }

    public String getProfileResourcesPath() {
        return profileResourcesPath;
    }

    public long getUserID() {
        return userID;
    }

    public String getSleepResourcesPath() {
        return sleepResourcesPath;
    }

    @Override
    public String toString() {
        return "User{" +
                "strengthTrainingActivitiesResourcesPath='" + strengthTrainingActivitiesResourcesPath + '\'' +
                ", weightResourcesPath='" + weightResourcesPath + '\'' +
                ", settingsResourcesPath='" + settingsResourcesPath + '\'' +
                ", diabetesResourcesPath='" + diabetesResourcesPath + '\'' +
                ", teamResourcesPath='" + teamResourcesPath + '\'' +
                ", fitnessActivitiesResourcesPath='" + fitnessActivitiesResourcesPath + '\'' +
                ", nutritionResourcesPath='" + nutritionResourcesPath + '\'' +
                ", generalMeasurementsResourcesPath='" + generalMeasurementsResourcesPath + '\'' +
                ", backgroundActivitiesResourcesPath='" + backgroundActivitiesResourcesPath + '\'' +
                ", recordsResourcesPath='" + recordsResourcesPath + '\'' +
                ", profileResourcesPath='" + profileResourcesPath + '\'' +
                ", userID=" + userID +
                ", sleepResourcesPath='" + sleepResourcesPath + '\'' +
                '}';
    }
}
