package endafarrell.healthgraph4j;


import org.joda.time.DateTime;

import java.net.URI;

public interface FitnessActivitySummary {
    public URI getUri();
    public long getUserID();
    public String getType();
    public String getSecondaryType();
    public String getEquipment();
    public DateTime getStartTime();
    public double getTotalDistance();
    public double getDuration();
    public int getAverageHeartRate();
    public double getTotalCalories();
    public double getClimb();
    public String getNotes();
    public boolean isLive();
    public String getSource();
    public URI getActivity();
}
