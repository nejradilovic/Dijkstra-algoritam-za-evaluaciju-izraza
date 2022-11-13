package ba.unsa.etf.rpr;
import java.util.Stack;

import static java.lang.Double.parseDouble;

public class ExpressionEvaluator {
    private static final Stack<String> operators = new Stack<String>();
    private static final Stack<Double> operands = new Stack<Double>();
    public static double evaluate(String s){
        String[] strSub = s.split(" ");
        for(String x: strSub) {
            validExpression(x);
            if (x.equals("(")) continue;
            else if (isOperator(x)) operators.push(x);
            else if (x.equals(")")) {
                String operator = operators.pop();
                double operand = operands.pop();
                switch (operator) {
                    case "+":
                        operand = operands.pop() + operand;
                        break;
                    case "-":
                        operand = operands.pop() - operand;
                        break;
                    case "*":
                        operand = operands.pop() * operand;
                        break;
                    case "/":
                        operand = operands.pop() / operand;
                        break;
                    case "^":
                        operand = Math.pow(operand, operand);
                        break;
                    case "sqrt":
                        operand = Math.sqrt(operand);
                        break;
                }
                operands.push(operand);
            } else operands.push(parseDouble(x));
        }
        return operands.pop();
}
static void validExpression(String s) throws RuntimeException{
        if(!isOperator(s) && !isNumber(s) && !s.equals("(") && !s.equals(")") && !(s.length()>1 && s.equals("sqrt"))  ) throw new RuntimeException(errorMessage);
}
    public static boolean isOperator(String s) {
        if(!s.equals("+") && !s.equals("-") && !s.equals("/") && !s.equals("*") && !s.equals("^") && !s.equals("sqrt")) return false;
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
