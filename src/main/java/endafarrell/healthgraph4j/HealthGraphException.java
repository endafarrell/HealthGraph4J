package endafarrell.healthgraph4j;

public class HealthGraphException extends Exception {
    public HealthGraphException(final String message) {
        super(message);
    }

    public HealthGraphException(final Exception exception) {
        super(exception);
    }
}
