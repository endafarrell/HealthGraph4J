package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.FitnessActivityHeartRate;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class FitnessActivityHeartRateImpl implements FitnessActivityHeartRate {
    private final double timestamp;
    private final int heartRate;

    @JsonCreator
    public FitnessActivityHeartRateImpl(
            @JsonProperty("timestamp") double timestamp,
            @JsonProperty("heart_rate") int heartRate) {
        this.timestamp = timestamp;
        this.heartRate = heartRate;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public int getHeartRate() {
        return heartRate;
    }

    @Override
    public String toString() {
        return "FitnessActivityHeartRate{" +
                "timestamp=" + timestamp +
                ", heartRate=" + heartRate +
                '}';
    }
}
