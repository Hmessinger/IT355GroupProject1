package Rules;

public class NUM02 {
    public int safeDivide(int numerator, int denominator){
        if (denominator == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }
        return numerator / denominator;
    }

    public int safeModulus(int numerator, int denominator){
        if (denominator == 0){
            throw new ArithmeticException("Cannot perform modulus by zero");
        }
        return numerator % denominator;
    }
}
