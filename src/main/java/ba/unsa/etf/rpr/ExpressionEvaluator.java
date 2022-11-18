package ba.unsa.etf.rpr;
import java.util.Stack;
import java.lang.Math;
import static java.lang.Double.parseDouble;

/**
 * ExpressionEvaluator class that has two Stacks as attributes
 * It computes the value of arithmetic expressions etc. ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 * @author Nejra Adilović
 * @version 1.0
 */
public class ExpressionEvaluator {
    private static final Stack<String> operators = new Stack<String>();
    private static final Stack<Double> operands = new Stack<Double>();
    private static int leftParenthesis = 0, rightParenthesis = 0;

    /**
     * evaluate method that calculates expressions using Dijkstra’s Algorithm for expression evaluation
     * @param s
     * @return result of expression
     */
    public static double evaluate(String s){
        String[] strSub = s.split(" ");
        for(String x: strSub) {
            validExpression(x);
            if (x.equals("(")) {
                leftParenthesis = leftParenthesis + 1;
                continue;
            }
            else if (isOperator(x)) operators.push(x);
            else if (x.equals(")")) {
                leftParenthesis = leftParenthesis - 1;
                rightParenthesis = rightParenthesis + 1;
                if(operators.size()>operands.size()) throw new RuntimeException(errorMessage);
                String operator = operators.pop();
                double operand = operands.pop();
                switch (operator) {
                    case "+":
                        operand = operands.pop() + operand;
                        break;
                    case "-":
                        operand = operands.pop() - operand;
                        break;
                    case "x":
                        operand = operands.pop() * operand;
                        break;
                    case "/":
                        if(operand == 0) throw new RuntimeException("Division by zero is not possible!");
                        operand = operands.pop() / operand;
                        break;
                    case "sqrt":
                        operand = Math.sqrt(operand);
                        break;
                }
                operands.push(operand);
            } else operands.push(parseDouble(x));
            if(leftParenthesis<operators.size()) throw new RuntimeException(errorMessage);
        }
        if(operators.size() > 0 || operands.size() != 1) throw new RuntimeException(errorMessage);
        return operands.pop();
}

    /**
     * Checks if the given string is in valid format
     * @param s
     * @throws RuntimeException if the expression isn't valid
     */
    static void validExpression(String s) throws RuntimeException{
        if(!s.equals("(") && !isOperator(s) && !isNumber(s) && !s.equals(")") ) throw new RuntimeException(errorMessage);
}

    /**
     *
     * @param s
     * @return true if the given string is a valid operator
     */
    public static boolean isOperator(String s) {
        if(!s.equals("+") && !s.equals("-") && !s.equals("/") && !s.equals("x") && !s.equals("sqrt")) return false;
        return true;
    }

    /**
     * Checks if the given string is a real number
     * @param s
     * @return true if given string is a real number, otherwise return false
     */
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

    /**
     * Error message if the received input is invalid
     */
    public static String errorMessage = "Invalid input!";
}
