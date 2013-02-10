package endafarrell.healthgraph4j.api;

import java.net.URI;
import java.util.List;

public interface Feed<T> {
    public int getSize();
    public String getPrevious();
    public String getNext();
    public List<T> getItems();
}
