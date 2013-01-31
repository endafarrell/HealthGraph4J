package endafarrell.healthgraph4j;

import org.joda.time.DateTime;

import java.net.URI;

public interface FitnessActivityItem {
    /**
     * The type of activity, as one of the following values: Running, Cycling, Mountain Biking, Walking, Hiking,
     * Downhill Skiing, Cross-Country Skiing, Snowboarding, Skating, Swimming, Wheelchair, Rowing, Elliptical, Other
     */
    String getType();

    /**
     * The starting time for the activity (e.g., Sat, 1 Jan 2011 00:00:00)
     */
    DateTime getStartTime();

    /**
     * The total distance for the activity, in meters.
     */
    double getTotalDistance();

    /**
     * The duration of the activity, in seconds;
     */
    double getDuration();

    /**
     * The URI of the detailed information for the past activity
     * @return
     */
   URI getURI();
}
