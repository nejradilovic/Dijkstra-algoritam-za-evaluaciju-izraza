package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import static ba.unsa.etf.rpr.ExpressionEvaluator.*;

class ExpressionEvaluatorTest {

    @Test
    void testEvaluate() {
        assertEquals(4,ExpressionEvaluator.evaluate("(2+2)"));
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