package endafarrell.healthgraph4j;


public final class HealthGraphFactory {
    private static HealthGraph INSTANCE;

    public HealthGraphFactory(Configuration configuration) throws HealthGraphException {
        synchronized (this) {
            if (INSTANCE == null) {
                INSTANCE = new HealthGraphImpl(configuration);
            }
        }
    }

    public HealthGraph getInstance() {
        return INSTANCE;
    }
}
