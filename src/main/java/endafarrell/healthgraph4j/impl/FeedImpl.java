package endafarrell.healthgraph4j.impl;

import endafarrell.healthgraph4j.api.Feed;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FeedImpl<T> implements Feed<T> {
    private final int size;
    private final URI previous;
    private final URI next;
    private final ArrayList<T> items;

    @JsonCreator
    public FeedImpl(@JsonProperty("size") int size,
                    @JsonProperty("previous") URI previous,
                    @JsonProperty("next") URI next,
                    @JsonProperty("items") ArrayList<T> items) {
        this.size = size;
        this.previous = previous;
        this.next = next;
        this.items = items;
    }

    public int getSize() {
        return size;
    }

    public URI getPrevious() {
        return previous;
    }

    public URI getNext() {
        return next;
    }

    public List<T> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Feed{size=");
        stringBuilder.append(size);
        stringBuilder.append(", previous=").append(previous);
        stringBuilder.append(", next=").append(next);
        stringBuilder.append(",items=[");
        stringBuilder.append(StringUtils.join(items, ", "));
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }
}
