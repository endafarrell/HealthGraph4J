package endafarrell.healthgraph4j.api;

import endafarrell.healthgraph4j.FitnessActivity;
import endafarrell.healthgraph4j.FitnessActivityItem;
import endafarrell.healthgraph4j.FitnessActivitySummary;
import endafarrell.healthgraph4j.HealthGraphException;

import java.net.URI;
import java.util.List;

public interface FitnessActivitiesResources {

    /**
     * Get the default first-page feed for the fitness_activities.
     * @return
     * @throws HealthGraphException
     */
    Feed<FitnessActivityItem> getFitnessActivityFeed() throws HealthGraphException;

    /**
     * Get a specific feed page for the fitness_activities.
     * @param next The particular page (obtained from the previous/first feed page's "next" attribute. A null value
     *             returns the default first-page feed.
     * @return
     * @throws HealthGraphException
     */
    Feed<FitnessActivityItem> getFitnessActivityFeed(URI next) throws HealthGraphException;

    List<FitnessActivityItem> getFitnessActivityFeed(boolean getAllFeedPages) throws HealthGraphException;

    FitnessActivitySummary getFitnessActivitySummary(FitnessActivityItem fitnessActivityItem) throws HealthGraphException;

    FitnessActivity getFitnessActivity(FitnessActivityItem fitnessActivityItem) throws HealthGraphException;


    List<FitnessActivityItem> getFitnessActivityItemList();
}
