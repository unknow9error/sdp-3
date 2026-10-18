public class TextFormatter implements Formatter {
    @Override
    public String format(String title, String content) {
        return "TEXT " + title + " | " + content;
    }
}
