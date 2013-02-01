package endafarrell.healthgraph4j;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class FitnessActivityWGS84Impl implements FitnessActivityWGS84 {
    private final double timestamp;
    private final double latitude;
    private final double longitude;
    private final double altitude;
    private final String type;

    @JsonCreator
    public FitnessActivityWGS84Impl(
            @JsonProperty("timestamp") double timestamp,
            @JsonProperty("latitude") double latitude,
            @JsonProperty("longitude") double longitude,
            @JsonProperty("altitude") double altitude,
            @JsonProperty("type") String type) {
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.type = type;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "FitnessActivityWGS84{" +
                "timestamp=" + timestamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", type='" + type + '\'' +
                '}';
    }
}
