

public class TestDividePartA {

    

    @Test
    public void testPositiveDivision() {
        // Basic case: divide two positive integers
        double result = calculator.divide(6, 2);
        assertEquals(3.0, result);
    }	
    @Test
    public void testNegativeDividend() {
        // Negative dividend should produce a negative result
        double result = calculator.divide(-12, 2);
        assertEquals(-6.0, result);
    }
    @Test
    public void testNonIntegerResult() {
        // Result should not be truncated — 5/2 = 2.5, not 2
        double result = calculator.divide(5, 2);
        assertEquals(2.5, result);
    }	
    @Test
    public void testZeroDividend() {
        // Zero divided by any non-zero number should be 0
        double result = calculator.divide(0, 5);
        assertEquals(0.0, result);
    }

}
