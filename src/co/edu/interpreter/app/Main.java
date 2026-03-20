package co.edu.interpreter.app;

import co.edu.interpreter.builder.ClauseRuleBuilder;
import co.edu.interpreter.context.Context;
import co.edu.interpreter.expression.Expression;

public class Main {

    public static void main(String[] args) {
        Expression rule = ClauseRuleBuilder.buildValidClauseRule();

        String clause1 = "El arrendatario pagará la renta mensual del inmueble.";
        String clause2 = "El inquilino abonará el canon anticipado del apartamento.";
        String clause3 = "El arrendatario pagará la renta del inmueble."; 
        String clause4 = "El inquilino subarrendará el canon mensual.";   
        String clause5 = "El ocupante cancelará el valor mensual.";       

        evaluateClause(rule, clause1);
        evaluateClause(rule, clause2);
        evaluateClause(rule, clause3);
        evaluateClause(rule, clause4);
        evaluateClause(rule, clause5);
    }

    private static void evaluateClause(Expression rule, String text) {
        Context context = new Context(text);
        boolean result = rule.interpret(context);

        System.out.println("Cláusula: " + text);
        System.out.println("¿Es válida? " + result);
        System.out.println("-----------------------------------");
    }
}
