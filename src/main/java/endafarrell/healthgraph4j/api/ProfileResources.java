package endafarrell.healthgraph4j.api;

import endafarrell.healthgraph4j.HealthGraphException;
import endafarrell.healthgraph4j.Profile;

public interface ProfileResources {
    Profile getProfile() throws HealthGraphException;
    Profile getProfile(int userId) throws HealthGraphException;
}
