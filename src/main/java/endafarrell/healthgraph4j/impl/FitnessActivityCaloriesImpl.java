package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.FitnessActivityCalories;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class FitnessActivityCaloriesImpl implements FitnessActivityCalories {
    private final double timestamp;
    private final double calories;

    @JsonCreator
    public FitnessActivityCaloriesImpl(
            @JsonProperty("timestamp") double timestamp,
            @JsonProperty("calories") double calories) {
        this.timestamp = timestamp;
        this.calories = calories;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public double getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "FitnessActivityCalories{" +
                "timestamp=" + timestamp +
                ", calories=" + calories +
                '}';
    }
}
