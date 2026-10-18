import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GradeReport extends Report {
    private final List<Integer> grades;

    public GradeReport(String id, List<Integer> grades, Formatter implementation) {
        super(id, implementation);
        if (grades.isEmpty() || grades.stream().anyMatch(g -> g == null || g < 0 || g > 100)) {
            throw new IllegalArgumentException("Grades must be between 0 and 100");
        }
        this.grades = List.copyOf(grades);
    }

    public List<Integer> getGrades() { return grades; }

    @Override
    public String execute() {
        long total = grades.stream().mapToLong(Integer::longValue).sum();
        String average = BigDecimal.valueOf(total).divide(BigDecimal.valueOf(grades.size()),
                2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
        return format("Grades", "Average: " + average);
    }
}
