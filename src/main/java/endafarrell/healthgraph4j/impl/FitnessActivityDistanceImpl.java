package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.FitnessActivityDistance;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class FitnessActivityDistanceImpl implements FitnessActivityDistance {
    private final double timestamp;

    @JsonCreator
    public FitnessActivityDistanceImpl(
            @JsonProperty("timestamp") double timestamp,
            @JsonProperty("distance") double distance) {
        this.timestamp = timestamp;
        this.distance = distance;
    }

    private final double distance;

    public double getTimestamp() {
        return timestamp;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "FitnessActivityDistance{" +
                "timestamp=" + timestamp +
                ", distance=" + distance +
                '}';
    }
}
