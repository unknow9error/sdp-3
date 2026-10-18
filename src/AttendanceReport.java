import java.util.List;

public class AttendanceReport extends Report {
    private final List<Boolean> sessions;

    public AttendanceReport(String id, List<Boolean> sessions, Formatter implementation) {
        super(id, implementation);
        if (sessions.isEmpty()) throw new IllegalArgumentException("Sessions cannot be empty");
        this.sessions = List.copyOf(sessions);
    }

    public List<Boolean> getSessions() { return sessions; }

    @Override
    public String execute() {
        long attended = sessions.stream().filter(Boolean::booleanValue).count();
        long percent = Math.round(100.0 * attended / sessions.size());
        return format("Attendance", attended + " of " + sessions.size()
                + " attended (" + percent + "%)");
    }
}
