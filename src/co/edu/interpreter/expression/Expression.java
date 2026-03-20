package co.edu.interpreter.expression;

import co.edu.interpreter.context.Context;

public interface Expression {
    boolean interpret(Context context);
}
