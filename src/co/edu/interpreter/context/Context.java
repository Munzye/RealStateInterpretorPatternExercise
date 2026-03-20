package co.edu.interpreter.context;

public class Context {
    private final String text;

    public Context(String text) {
        this.text = normalize(text);
    }

    public String getText() {
        return text;
    }

    private String normalize(String input) {
        if (input == null) {
            return "";
        }
        return input.toLowerCase().trim().replaceAll("\\s+", " ");
    }
}
