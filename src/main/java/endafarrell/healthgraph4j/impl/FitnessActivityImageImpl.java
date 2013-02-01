package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.FitnessActivityImage;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.net.URI;


public class FitnessActivityImageImpl implements FitnessActivityImage {
    private final double timestamp;
    private final double latitude;
    private final double longitude;
    private final double altitude;
    private final URI uri;

    @JsonCreator
    public FitnessActivityImageImpl(
            @JsonProperty("timestamp") double timestamp,
            @JsonProperty("latitude") double latitude,
            @JsonProperty("longitude") double longitude,
            @JsonProperty("altitude") double altitude,
            @JsonProperty("uri") URI uri,
            @JsonProperty("thumbnail_uri") URI thumbnailUri) {
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.uri = uri;
        this.thumbnailUri = thumbnailUri;
    }

    private final URI thumbnailUri;

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

    public URI getURI() {
        return uri;
    }

    public URI getThumbnailURI() {
        return thumbnailUri;
    }

    @Override
    public String toString() {
        return "FitnessActivityImage{" +
                "timestamp=" + timestamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", uri=" + uri +
                ", thumbnailUri=" + thumbnailUri +
                '}';
    }
}
