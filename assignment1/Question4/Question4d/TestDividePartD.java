public class TestDividePartD {
    //new tests
    @Test
    public void testNumericOverflow() {
        // Basic case: divide the max of the positive max number by another number that would cause numeric overflow. Program should have some way of preventing the program from breaking
        Double result = calculator.divide(Double.MAX_VALUE, 0.1);
        assertEquals(null, result);
    }
    @Test
    public void testNegativeNumericOverflow () {
       // Basic case: divide the max of the negative max number by another number that would cause numeric overflow. Program should have some way of preventing the program from breaking
        Double result = calculator.divide(-Double.MAX_VALUE, 0.1);
        assertEquals(null, result);
    }
    

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
