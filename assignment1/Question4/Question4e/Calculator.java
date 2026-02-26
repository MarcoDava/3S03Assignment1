public class Calculator {
    public Double divide(double dividend, double divisor) {  
        if (divisor == 0.0) {  
            throw new ArithmeticException("Division by zero");  
        }  
        double result = dividend / divisor;  
        if (Double.isInfinite(result)) {
            return null;
        }
        return result;
    } 
}
