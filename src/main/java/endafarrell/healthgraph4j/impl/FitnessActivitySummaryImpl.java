package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.FitnessActivitySummary;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.joda.time.DateTime;

import java.net.URI;

public class FitnessActivitySummaryImpl implements FitnessActivitySummary {

    //uri	String	The URI for this activity	N
    private final URI uri;

    //userID	Integer	The unique ID of the user for the activity	N
    private final long userID;

    //type	String	The type of activity, as one of the following values: Running, Cycling, Mountain Biking, Walking, Hiking, Downhill Skiing, Cross-Country Skiing, Snowboarding, Skating, Swimming, Wheelchair, Rowing, Elliptical, Other	Y
    private String type;

    //secondary_type	String	The secondary type of the activity, as a free-form string (max. 64 characters). This field is used only if the type field is Other."	Y
    private String secondaryType;

    //equipment	String	The equipment used to complete this activity, as one of the following values: None, Treadmill, Stationary Bike, Elliptical, Row Machine. (Optional; if not specified, None is assumed.)	Y
    private String equipment;

    //start_time	String	The starting time for the activity (e.g., Sat, 1 Jan 2011 00:00:00)	Y
    private DateTime startTime;

    //total_distance	Double	The total distance traveled, in meters	Y
    private double totalDistance;

    //duration	Double	The duration of the activity, in seconds	Y
    private double duration;

    //average_heart_rate	Integer	The user’s average heart rate, in beats per minute (omitted if not available)	Y
    private int averageHeartRate;

    //total_calories	Double	The total calories burned	Y
    private double totalCalories;

    //climb	Double	The total elevation climbed over the course of the activity, in meters	N
    private double climb;

    //notes	String	Any notes that the user has associated with the activity	Y
    private String notes;

    //is_live	Boolean	Whether this activity is currently being tracked via RunKeeper Live	N
    private boolean isLive;

    //source	String	The name of the application that last modified this activity	N
    private final String source;

    //activity	String	The URL of the user’s public, human-readable page for this activity	N
    private final URI activity;

    @JsonCreator
    public FitnessActivitySummaryImpl(
            @JsonProperty("uri") URI uri,
            @JsonProperty("userID") long userID,
            @JsonProperty("source") String source,
            @JsonProperty("activity") URI activity, String type, String secondaryType, String equipment, DateTime startTime, double totalDistance, double duration, int averageHeartRate, double totalCalories, double climb, String notes, boolean live) {
        this.uri = uri;
        this.userID = userID;
        this.source = source;
        this.activity = activity;
        this.type = type;
        this.secondaryType = secondaryType;
        this.equipment = equipment;
        this.startTime = startTime;
        this.totalDistance = totalDistance;
        this.duration = duration;
        this.averageHeartRate = averageHeartRate;
        this.totalCalories = totalCalories;
        this.climb = climb;
        this.notes = notes;
        this.isLive = live;
    }
}
