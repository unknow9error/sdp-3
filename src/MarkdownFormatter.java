public class MarkdownFormatter implements Formatter {
    @Override
    public String format(String title, String content) {
        return "## " + title + "\n\n" + content;
    }
}
