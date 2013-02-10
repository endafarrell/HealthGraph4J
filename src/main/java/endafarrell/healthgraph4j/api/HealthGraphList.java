package endafarrell.healthgraph4j.api;

import java.util.List;

public interface HealthGraphList<T> extends List<T> {
    void setHealthGraphSize(int size);
    int getHealthGraphSize();
}
