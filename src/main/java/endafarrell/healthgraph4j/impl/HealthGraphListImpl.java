package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.api.HealthGraphList;

import java.util.ArrayList;
import java.util.List;

public class HealthGraphListImpl<T> extends ArrayList<T> implements HealthGraphList<T>  {
    private int healthGraphSize;

    public HealthGraphListImpl(int initialCapacity) {
        super(initialCapacity);
    }

    public HealthGraphListImpl(List<T> tList, int healthGraphSize) {
        super(tList);
        this.healthGraphSize = healthGraphSize;
    }

    public void setHealthGraphSize(int size) {
        this.healthGraphSize = size;
    }

    public int getHealthGraphSize() {
        return healthGraphSize;
    }
}
