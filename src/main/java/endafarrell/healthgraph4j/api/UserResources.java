package endafarrell.healthgraph4j.api;

import endafarrell.healthgraph4j.User;

public interface UserResources {
    static String USER_RESOURCES_PATH = "/user";

    User getUser();

}
