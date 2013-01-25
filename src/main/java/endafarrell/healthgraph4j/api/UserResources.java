package endafarrell.healthgraph4j.api;

import endafarrell.healthgraph4j.HealthGraphException;
import endafarrell.healthgraph4j.Profile;
import endafarrell.healthgraph4j.User;

/**
 * <pre>
 *     {
   "strength_training_activities": "/strengthTrainingActivities",
   "weight": "/weight",
   "settings": "/settings",
   "diabetes": "/diabetes",
   "team": "/team",
   "sleep": "/sleep",
   "fitness_activities": "/fitnessActivities",
   "userID": 14477296,
   "nutrition": "/nutrition",
   "general_measurements": "/generalMeasurements",
   "background_activities": "/backgroundActivities",
   "records": "/records",
   "profile": "/profile"
   }
 * </pre>
 */
public interface UserResources {
    static String USER_RESOURCES_PATH = "/user";

    User getUser();

}
