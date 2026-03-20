package co.edu.interpreter.expression;

import co.edu.interpreter.context.Context;

public class AndExpression implements Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    public AndExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public boolean interpret(Context context) {
        return leftExpression.interpret(context) && rightExpression.interpret(context);
    }
}
