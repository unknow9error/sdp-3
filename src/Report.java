import java.util.Objects;

public abstract class Report {
    private final String id;
    private Formatter implementation;

    protected Report(String id, Formatter implementation) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID is required");
        this.id = id;
        this.implementation = Objects.requireNonNull(implementation);
    }

    public final String getId() { return id; }
    public final void setImplementation(Formatter implementation) {
        this.implementation = Objects.requireNonNull(implementation);
    }
    protected final String format(String title, String content) {
        return implementation.format(title, content);
    }
    public abstract String execute();
}
