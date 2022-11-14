package ba.unsa.etf.rpr;
import static ba.unsa.etf.rpr.ExpressionEvaluator.*;

/**
 * Dijkstra’s Algorithm for expression evaluation
 * @author Nejra Adilović
 */
public class App
{
    /**
     * Main method of class App
     * @param args array of sequence of characters (Strings) that are passed to the main function
     */
    public static void main( String[] args ) {
        if(args.length % 2 == 0){
            throw new RuntimeException(errorMessage);
        }
        StringBuilder entry = new StringBuilder();
        for(String x : args) {
            validExpression(x);
            entry.append(x).append(" ");
        }
        double result = evaluate(String.valueOf(entry));
        System.out.println("The result using \"Dijkstra's Algorithm for expression evaluation\" is " + result);
    }
}
