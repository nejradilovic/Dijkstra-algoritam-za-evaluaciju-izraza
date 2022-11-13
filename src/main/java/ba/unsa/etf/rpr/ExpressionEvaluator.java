package ba.unsa.etf.rpr;
import java.util.Stack;

import static java.lang.Double.parseDouble;

public class ExpressionEvaluator {
    private static final Stack<String> operators = new Stack<String>();
    private static final Stack<Double> operands = new Stack<Double>();
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULT = "*";
    private static final String DIV = "/";
    private static final String POW = "^";
    private static final String SQRT = "sqrt";
    public static double evaluate(String s){
        String[] strSub = s.split(" ");
        for(String x: strSub) {
            validExpression(x);
            if (x.equals(LEFT_PARENTHESIS)) continue;
            else if (isOperator(x)) operators.push(x);
            else if (x.equals(RIGHT_PARENTHESIS)) {
                String operator = operators.pop();
                double operand = operands.pop();
                switch (operator) {
                    case PLUS:
                        operand = operands.pop() + operand;
                        break;
                    case MINUS:
                        operand = operands.pop() - operand;
                        break;
                    case MULT:
                        operand = operands.pop() * operand;
                        break;
                    case DIV:
                        operand = operands.pop() / operand;
                        break;
                    case POW:
                        operand = Math.pow(operand, operand);
                        break;
                    case SQRT:
                        operand = Math.sqrt(operand);
                        break;
                }
                operands.push(operand);
            } else operands.push(parseDouble(x));
        }
        return operands.pop();
}
static void validExpression(String s) throws RuntimeException{
        if(!isOperator(s) && !isNumber(s) && !LEFT_PARENTHESIS.equals(s) && !RIGHT_PARENTHESIS.equals(s)) throw new RuntimeException(errorMessage);
}
    public static boolean isOperator(String s) {
        if(!PLUS.equals(s) && !MINUS.equals(s) && !DIV.equals(s) && !MULT.equals(s) && !POW.equals(s) && !SQRT.equals(s)) return false;
        return true;
    }
    public static boolean isNumber(String s) {
        double integerValue;
        if (s == null || s.equals("")) {
            return false;
        }
        try {
            integerValue = Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static String errorMessage = "Invalid input!";
}
