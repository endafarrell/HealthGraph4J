package endafarrell.healthgraph4j.api;

import endafarrell.healthgraph4j.FitnessActivity;
import endafarrell.healthgraph4j.FitnessActivityItem;
import endafarrell.healthgraph4j.FitnessActivitySummary;
import endafarrell.healthgraph4j.HealthGraphException;

public interface FitnessActivitiesResources {

    HealthGraphList<FitnessActivityItem> getFitnessActivityList() throws HealthGraphException;
    HealthGraphList<FitnessActivityItem> getFitnessActivityList(boolean getAllFeedPages) throws HealthGraphException;
    HealthGraphList<FitnessActivityItem> getFitnessActivityList(int count) throws HealthGraphException;

    FitnessActivitySummary getFitnessActivitySummary(FitnessActivityItem fitnessActivityItem) throws HealthGraphException;
    FitnessActivity getFitnessActivity(FitnessActivityItem fitnessActivityItem) throws HealthGraphException;
}
