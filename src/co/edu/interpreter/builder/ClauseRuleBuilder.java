package co.edu.interpreter.builder;

import co.edu.interpreter.expression.AndExpression;
import co.edu.interpreter.expression.Expression;
import co.edu.interpreter.expression.NotExpression;
import co.edu.interpreter.expression.OrExpression;
import co.edu.interpreter.expression.TerminalExpression;

public class ClauseRuleBuilder {

    private ClauseRuleBuilder() {
    }

    public static Expression buildValidClauseRule() {
        Expression arrendatario = new TerminalExpression("arrendatario");
        Expression inquilino = new TerminalExpression("inquilino");
        Expression subjectRule = new OrExpression(arrendatario, inquilino);

        Expression pagara = new TerminalExpression("pagará");
        Expression pagaraSinTilde = new TerminalExpression("pagara");
        Expression abonara = new TerminalExpression("abonará");
        Expression abonaraSinTilde = new TerminalExpression("abonara");

        Expression actionRule = new OrExpression(
                new OrExpression(pagara, pagaraSinTilde),
                new OrExpression(abonara, abonaraSinTilde)
        );

        Expression renta = new TerminalExpression("renta");
        Expression canon = new TerminalExpression("canon");
        Expression objectRule = new OrExpression(renta, canon);

        Expression mensual = new TerminalExpression("mensual");
        Expression anticipado = new TerminalExpression("anticipado");
        Expression parameterRule = new OrExpression(mensual, anticipado);

        Expression prohibitedWord = new TerminalExpression("subarrendar");
        Expression notProhibitedRule = new NotExpression(prohibitedWord);

        Expression subjectAndAction = new AndExpression(subjectRule, actionRule);
        Expression objectAndParameter = new AndExpression(objectRule, parameterRule);
        Expression mainStructure = new AndExpression(subjectAndAction, objectAndParameter);

        return new AndExpression(mainStructure, notProhibitedRule);
    }
}
