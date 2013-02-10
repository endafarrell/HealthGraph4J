package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.FitnessActivityItem;
import endafarrell.healthgraph4j.api.HealthGraphList;

import java.util.Collections;
import java.util.List;

public class UnmodifiableHealthGraphListImpl<T> extends HealthGraphListImpl<T> {
    public UnmodifiableHealthGraphListImpl(HealthGraphList<T> tList) {
        super(Collections.unmodifiableList(tList), tList.getHealthGraphSize());
    }

    public UnmodifiableHealthGraphListImpl(List<T> tList, int healthGraphSize) {
        super(Collections.unmodifiableList(tList), healthGraphSize);
    }
}
