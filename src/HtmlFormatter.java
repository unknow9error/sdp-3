public class HtmlFormatter implements Formatter {
    @Override
    public String format(String title, String content) {
        return "<article><h1>" + escape(title) + "</h1><p>" + escape(content) + "</p></article>";
    }

    private String escape(String text) {
        return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#39;");
    }
}
