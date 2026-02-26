public class Calculator { 
    public double divide(double dividend, double divisor) { 
        if (divisor == 0.0) { 
            throw new ArithmeticException("Division by zero"); 
        } 
        return dividend / divisor; 
    } 
}
