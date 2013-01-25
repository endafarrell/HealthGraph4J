package endafarrell.healthgraph4j;

import org.joda.time.DateTime;

import java.net.URI;

/**
 * {
   "birthday": "Wed, 9 Jul 1975 00:00:00",
   "location": "Berlin, Germany",
   "name": "Enda Farrell",
   "elite": "false",
   "gender": "M",
   "athlete_type": "Runner",
   "profile": "http://runkeeper.com/user/endafarrell"
   }
 */
public interface Profile {
    DateTime getBirthday();
    String getLocation();
    String getName();
    boolean isElite();
    String getGender();
    String getAthleteType();
    URI getProfile();
    URI getSmallPicture();
    URI getNormalPicture();
    URI getMediumPicture();
    URI getLargePicture();
}
