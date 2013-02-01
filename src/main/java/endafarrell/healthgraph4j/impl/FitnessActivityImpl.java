package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.*;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class FitnessActivityImpl extends FitnessActivitySummaryImpl implements FitnessActivity  {
    private final ArrayList<FitnessActivityDistanceImpl> distances;
    private final ArrayList<FitnessActivityHeartRateImpl> heartRates;
    private final ArrayList<FitnessActivityCaloriesImpl> calories;

    private final ArrayList<FitnessActivityWGS84Impl> path;
    private final ArrayList<FitnessActivityImageImpl> images;
    private final String comments;
    private final URI next;
    private final URI previous;
    private final List<URI> nearestTeammateFitnessActivities;
    private final URI nearestStrengthTrainingActivity;
    private final List<URI> nearestTeammateStrengthTrainingActivities;
    private final URI nearestBackgroundActivity;
    private final List<URI> nearestTeammateBackgroundActivities;
    private final URI nearestSleep;
    private final List<URI> nearestTeammateBackgroundSleeps;
    private final URI nearestNutrition;
    private final List<URI> nearestTeammateNutrition;
    private final URI nearestWeight;
    private final List<URI> nearestTeammateWeights;
    private final URI nearestGeneralMeasurement;
    private final List<URI> nearestTeammateGeneralMeasurements;
    private final URI nearestDiabetes;
    private final List<URI> nearestTeammateDiabetes;

    @JsonCreator
    public FitnessActivityImpl(
            @JsonProperty("uri") URI uri,
            @JsonProperty("userID") long userID,
            @JsonProperty("source") String source,
            @JsonProperty("activity") URI activity,
            @JsonProperty("type") String type,
            @JsonProperty("secondary_type") String secondaryType,
            @JsonProperty("equipment") String equipment,
            @JsonProperty("start_time") String startTime,
            @JsonProperty("total_distance") double totalDistance,
            @JsonProperty("duration") double duration,
            @JsonProperty("average_heart_rate") int averageHeartRate,
            @JsonProperty("total_calories") double totalCalories,
            @JsonProperty("climb") double climb,
            @JsonProperty("notes") String notes,
            @JsonProperty("is_live") boolean isLive,
            @JsonProperty("distance") ArrayList<FitnessActivityDistanceImpl> distances,
            @JsonProperty("heart_rate") ArrayList<FitnessActivityHeartRateImpl> heartRates,
            @JsonProperty("calories") ArrayList<FitnessActivityCaloriesImpl> calories,
            @JsonProperty("path") ArrayList<FitnessActivityWGS84Impl> path,
            @JsonProperty("images") ArrayList<FitnessActivityImageImpl> images,
            @JsonProperty("comments") String comments,
            @JsonProperty("next") URI next,
            @JsonProperty("previous") URI previous,
            @JsonProperty("nearest_teammate_fitness_activities") ArrayList<URI> nearestTeammateFitnessActivities,
            @JsonProperty("nearest_strength_training_activity") URI nearestStrengthTrainingActivity,
            @JsonProperty("nearest_teammate_strength_training_activities") ArrayList<URI> nearestTeammateStrengthTrainingActivities,
            @JsonProperty("nearest_background_Activity") URI nearestBackgroundActivity,
            @JsonProperty("nearest_teammate_background_activities") ArrayList<URI> nearestTeammateBackgroundActivities,
            @JsonProperty("nearest_sleep") URI nearestSleep,
            @JsonProperty("nearest_teammate_sleep") ArrayList<URI> nearestTeammateBackgroundSleeps,
            @JsonProperty("nearest_nutrition") URI nearestNutrition,
            @JsonProperty("nearest_teammate_nutrition") ArrayList<URI> nearestTeammateNutrition,
            @JsonProperty("nearest_weight") URI nearestWeight,
            @JsonProperty("nearest_teammate_weight") ArrayList<URI> nearestTeammateWeights,
            @JsonProperty("nearest_general_measurement") URI nearestGeneralMeasurement,
            @JsonProperty("nearest_teammate_general_measurements") ArrayList<URI> nearestTeammateGeneralMeasurements,
            @JsonProperty("nearest_diabetes") URI nearestDiabetes,
            @JsonProperty("nearest_teammate_diabetes") ArrayList<URI> nearestTeammateDiabetes) {
        super(uri, userID, source, activity, type, secondaryType, equipment, startTime,
                totalDistance, duration, averageHeartRate, totalCalories, climb, notes, isLive);
        this.distances = distances;
        this.heartRates = heartRates;
        this.calories = calories;
        this.path = path;
        this.images = images;
        this.comments = comments;
        this.next = next;
        this.previous = previous;
        this.nearestTeammateFitnessActivities = nearestTeammateFitnessActivities;
        this.nearestStrengthTrainingActivity = nearestStrengthTrainingActivity;
        this.nearestTeammateStrengthTrainingActivities = nearestTeammateStrengthTrainingActivities;
        this.nearestBackgroundActivity = nearestBackgroundActivity;
        this.nearestTeammateBackgroundActivities = nearestTeammateBackgroundActivities;
        this.nearestSleep = nearestSleep;
        this.nearestTeammateBackgroundSleeps = nearestTeammateBackgroundSleeps;
        this.nearestNutrition = nearestNutrition;
        this.nearestTeammateNutrition = nearestTeammateNutrition;
        this.nearestWeight = nearestWeight;
        this.nearestTeammateWeights = nearestTeammateWeights;
        this.nearestGeneralMeasurement = nearestGeneralMeasurement;
        this.nearestTeammateGeneralMeasurements = nearestTeammateGeneralMeasurements;
        this.nearestDiabetes = nearestDiabetes;
        this.nearestTeammateDiabetes = nearestTeammateDiabetes;
    }

    public List<FitnessActivityDistanceImpl> getDistances() {
        return distances;
    }

    public List<FitnessActivityHeartRateImpl> getHeartRates() {
        return heartRates;
    }

    public List<FitnessActivityCaloriesImpl> getCalories() {
        return calories;
    }

    public List<FitnessActivityWGS84Impl> getPath() {
        return path;
    }

    public List<FitnessActivityImageImpl> getImages() {
        return images;
    }

    public String getComments() {
        return comments;
    }

    public URI getNext() {
        return next;
    }

    public URI getPrevious() {
        return previous;
    }

    public List<URI> getNearestTeammateFitnessActivities() {
        return nearestTeammateFitnessActivities;
    }

    public URI getNearestStrengthTrainingActivity() {
        return nearestStrengthTrainingActivity;
    }

    public List<URI> getNearestTeammateStrengthTrainingActivities() {
        return nearestTeammateStrengthTrainingActivities;
    }

    public URI getNearestBackgroundActivity() {
        return nearestBackgroundActivity;
    }

    public List<URI> getNearestTeammateBackgroundActivities() {
        return nearestTeammateBackgroundActivities;
    }

    public URI getNearestSleep() {
        return nearestSleep;
    }

    public List<URI> getNearestTeammateBackgroundSleeps() {
        return nearestTeammateBackgroundSleeps;
    }

    public URI getNearestNutrition() {
        return nearestNutrition;
    }

    public List<URI> getNearestTeammateNutritions() {
        return nearestTeammateNutrition;
    }

    public URI getNearestWeight() {
        return nearestWeight;
    }

    public List<URI> getNearestTeammateWeights() {
        return nearestTeammateWeights;
    }

    public URI getNearestGeneralMeasurement() {
        return nearestGeneralMeasurement;
    }

    public List<URI> getNearestTeammateGeneralMeasurements() {
        return nearestTeammateGeneralMeasurements;
    }

    public URI getNearestDiabetes() {
        return nearestDiabetes;
    }

    public List<URI> getNearestTeammateDiabetes() {
        return nearestTeammateDiabetes;
    }

    @Override
    public String toString() {
        return "FitnessActivity{" +
                "distances=" + distances +
                ", heartRates=" + heartRates +
                ", calories=" + calories +
                ", path=" + path +
                ", images=" + images +
                ", comments='" + comments + '\'' +
                ", next=" + next +
                ", previous=" + previous +
                ", nearestTeammateFitnessActivities=" + nearestTeammateFitnessActivities +
                ", nearestStrengthTrainingActivity=" + nearestStrengthTrainingActivity +
                ", nearestTeammateStrengthTrainingActivities=" + nearestTeammateStrengthTrainingActivities +
                ", nearestBackgroundActivity=" + nearestBackgroundActivity +
                ", nearestTeammateBackgroundActivities=" + nearestTeammateBackgroundActivities +
                ", nearestSleep=" + nearestSleep +
                ", nearestTeammateBackgroundSleeps=" + nearestTeammateBackgroundSleeps +
                ", nearestNutrition=" + nearestNutrition +
                ", nearestTeammateNutrition=" + nearestTeammateNutrition +
                ", nearestWeight=" + nearestWeight +
                ", nearestTeammateWeights=" + nearestTeammateWeights +
                ", nearestGeneralMeasurement=" + nearestGeneralMeasurement +
                ", nearestTeammateGeneralMeasurements=" + nearestTeammateGeneralMeasurements +
                ", nearestDiabetes=" + nearestDiabetes +
                ", nearestTeammateDiabetes=" + nearestTeammateDiabetes +
                '}';
    }
}
