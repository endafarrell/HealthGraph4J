package endafarrell.healthgraph4j;

import java.net.URI;

public interface FitnessActivityImage {
    double getTimestamp();
    double getLatitude();
    double getLongitude();
    double getAltitude();
    URI getURI();
    URI getThumbnailURI();
}
