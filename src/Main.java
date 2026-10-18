import java.util.List;

public class Main {
    private static int passed;
    private static int total;
    private static final List<Boolean> SESSIONS = List.of(true, true, false, true);
    private static final List<Integer> GRADES = List.of(70, 80, 90);
    private static final String ATTENDANCE_TEXT = "TEXT Attendance | 3 of 4 attended (75%)";
    private static final String ATTENDANCE_HTML =
            "<article><h1>Attendance</h1><p>3 of 4 attended (75%)</p></article>";

    public static void main(String[] args) {
        if (args.length != 1 || !args[0].equals("--demo")) {
            System.err.println("Usage: java -cp out Main --demo");
            System.exit(2);
        }
        compare("T1", "AttendanceReport + TextFormatter",
                new AttendanceReport("attendance", SESSIONS, new TextFormatter()).execute(), ATTENDANCE_TEXT);
        compare("T2", "AttendanceReport + HtmlFormatter",
                new AttendanceReport("attendance", SESSIONS, new HtmlFormatter()).execute(), ATTENDANCE_HTML);
        compare("T3", "GradeReport + TextFormatter",
                new GradeReport("grades", GRADES, new TextFormatter()).execute(), "TEXT Grades | Average: 80");
        compare("T4", "GradeReport + HtmlFormatter",
                new GradeReport("grades", GRADES, new HtmlFormatter()).execute(),
                "<article><h1>Grades</h1><p>Average: 80</p></article>");
        runtimeSwitch();
        // EXTENSION_CHECKS
        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
        if (passed != total) System.exit(1);
    }

    private static void runtimeSwitch() {
        AttendanceReport original = new AttendanceReport("switch-1", SESSIONS, new TextFormatter());
        AttendanceReport afterSwitch = original;
        String idBefore = original.getId();
        List<Boolean> dataBefore = original.getSessions();
        String before = original.execute();
        afterSwitch.setImplementation(new HtmlFormatter());
        String after = afterSwitch.execute();
        boolean sameObject = original == afterSwitch;
        boolean stateUnchanged = idBefore.equals(afterSwitch.getId())
                && dataBefore.equals(afterSwitch.getSessions()) && dataBefore.equals(SESSIONS);
        boolean result = sameObject && stateUnchanged && before.equals(ATTENDANCE_TEXT)
                && after.equals(ATTENDANCE_HTML);
        record("T5", result, "AttendanceReport + TextFormatter -> HtmlFormatter"
                + " | sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged
                + " | before=" + before + " | after=" + after);
        if (!result) System.out.println("  expected=same object, preserved ID/data, correct TEXT/HTML results");
    }

    private static void compare(String id, String roles, String actual, String expected) {
        boolean success = actual.equals(expected);
        record(id, success, roles + " | result=" + actual.replace("\n", "\\n"));
        if (!success) System.out.println("  expected=" + expected.replace("\n", "\\n"));
    }

    private static void record(String id, boolean success, String detail) {
        total++;
        if (success) passed++;
        System.out.println(id + " " + (success ? "PASS" : "FAIL") + " | " + detail);
    }
}
