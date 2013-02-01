package endafarrell.healthgraph4j.api;

import endafarrell.healthgraph4j.FitnessActivity;
import endafarrell.healthgraph4j.FitnessActivityItem;
import endafarrell.healthgraph4j.FitnessActivitySummary;
import endafarrell.healthgraph4j.HealthGraphException;

public interface FitnessActivitiesResources {

    Feed<FitnessActivityItem> getFitnessActivityFeed() throws HealthGraphException;

    FitnessActivitySummary getFitnessActivitySummary(FitnessActivityItem fitnessActivityItem);
}
