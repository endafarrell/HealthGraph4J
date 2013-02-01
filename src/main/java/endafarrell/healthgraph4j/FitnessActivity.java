package endafarrell.healthgraph4j;

import endafarrell.healthgraph4j.impl.FitnessActivityCaloriesImpl;
import endafarrell.healthgraph4j.impl.FitnessActivityDistanceImpl;
import endafarrell.healthgraph4j.impl.FitnessActivityHeartRateImpl;
import endafarrell.healthgraph4j.impl.FitnessActivityImageImpl;

import java.net.URI;
import java.util.List;

public interface FitnessActivity extends FitnessActivitySummary {
    List<FitnessActivityDistanceImpl> getDistances();
    List<FitnessActivityHeartRateImpl> getHeartRates();
    List<FitnessActivityCaloriesImpl> getCalories();
    List<FitnessActivityWGS84Impl> getPath();
    List<FitnessActivityImageImpl> getImages();
    String getComments();
    URI getNext();
    URI getPrevious();
    List<URI> getNearestTeammateFitnessActivities();
    URI getNearestStrengthTrainingActivity();
    List<URI> getNearestTeammateStrengthTrainingActivities();
    URI getNearestBackgroundActivity();
    List<URI> getNearestTeammateBackgroundActivities();
    URI getNearestSleep();
    List<URI> getNearestTeammateBackgroundSleeps();
    URI getNearestNutrition();
    List<URI> getNearestTeammateNutritions();
    URI getNearestWeight();
    List<URI> getNearestTeammateWeights();
    URI getNearestGeneralMeasurement();
    List<URI> getNearestTeammateGeneralMeasurements();
    URI getNearestDiabetes();
    List<URI> getNearestTeammateDiabetes();

}
