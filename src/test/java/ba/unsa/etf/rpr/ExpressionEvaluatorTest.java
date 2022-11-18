package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import static ba.unsa.etf.rpr.ExpressionEvaluator.*;

/**
 * ExpressionEvaluatorTest class that tests our functions and evaluator algorithm
 */
class ExpressionEvaluatorTest {

    @Test
    void testEvaluate() {
        assertEquals(4,ExpressionEvaluator.evaluate("( 2 + 2 )"));
    }
    @Test
    void testEvaluate1() {
        assertEquals(10,ExpressionEvaluator.evaluate("( 25 - ( 5 x 3 ) )"));
    }
    @Test
    void testEvaluate2() {
        assertEquals(4,ExpressionEvaluator.evaluate("( 24 / ( 2 x 3 ) )"));
    }
    @Test
    void testEvaluate3() {
        assertEquals(4,ExpressionEvaluator.evaluate("( sqrt 16 )"));
    }
    @Test
    void testEvaluate4() {
        assertEquals(11,ExpressionEvaluator.evaluate("( 2 + ( 3 x ( sqrt 9 ) ) )"));
    }

    @Test
    void testValidExpression() {
        assertThrows(RuntimeException.class, () -> validExpression(" "),errorMessage);
    }

    @Test
    void testIsOperator() {
        assertEquals(isOperator("+"),true);
    }

    @Test
    void testIsNumber() {
        assertEquals(isNumber("2.36"),true);
    }
}