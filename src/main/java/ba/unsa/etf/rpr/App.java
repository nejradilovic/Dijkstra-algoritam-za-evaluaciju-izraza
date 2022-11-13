package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.ExpressionEvaluator.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if(args.length%2==0){
            throw new RuntimeException(errorMessage);
        }
        StringBuilder entry = new StringBuilder(" ");
        for(String x : args) {
            isOperator(x);
            entry.append(x).append(" ");
        }
        double result = evaluate(String.valueOf(entry));
        System.out.println("The result using \"Dijkstra's Algorithm for expression evaluation\" is " + result);
    }
}
