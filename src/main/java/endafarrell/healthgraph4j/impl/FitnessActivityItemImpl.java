package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.FitnessActivityItem;
import endafarrell.healthgraph4j.HealthGraph;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import java.net.URI;


public class FitnessActivityItemImpl implements FitnessActivityItem {
    @JsonCreator
    public FitnessActivityItemImpl(
            @JsonProperty("type") String type,
            @JsonProperty("start_time") String startTime,
            @JsonProperty("total_distance") double totalDistance,
            @JsonProperty("duration") double duration,
            @JsonProperty("uri") URI uri) {
        this.type = type;
        this.startTime = HealthGraph.dateFormatter.parseDateTime(startTime);
        this.totalDistance = totalDistance;
        this.duration = duration;
        this.uri = uri;
    }

    private final String type;
    private final DateTime startTime;
    private final double totalDistance;
    private final double duration;
    private final URI uri;

    public String getType() {
        return type;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public double getDuration() {
        return duration;
    }

    public URI getURI() {
        return uri;
    }

    @Override
    public String toString() {
        return "FitnessActivityItem{" +
                "type='" + type + '\'' +
                ", startTime=" + startTime +
                ", totalDistance=" + totalDistance +
                ", duration=" + duration +
                ", uri=" + uri +
                '}';
    }
}
