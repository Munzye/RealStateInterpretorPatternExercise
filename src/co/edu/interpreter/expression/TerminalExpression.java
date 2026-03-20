package co.edu.interpreter.expression;

import co.edu.interpreter.context.Context;

public class TerminalExpression implements Expression {

    private final String keyword;

    public TerminalExpression(String keyword) {
        this.keyword = keyword.toLowerCase().trim();
    }

    @Override
    public boolean interpret(Context context) {
        return context.getText().contains(keyword);
    }

    public String getKeyword() {
        return keyword;
    }
}
