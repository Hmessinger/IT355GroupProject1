package HoganRules;

/**
 * This class has code for the rule MET01 (Never use assertions to validate
 * method arguments).
 * This code has a divide method that checks to make sure the denominator being
 * used isn't 0. The method throws an IllegalArgumentException to check
 * denominator argument rather than using an assertion.
 */
public class MET01 {

    // This method uses an exception to ensure that the denominator isn't 0.
    // This method of validation is more secure than using assertions.
    private static int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator must not be zero.");
        }
        return numerator / denominator;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 5));
        System.out.println(divide(10, 0)); // This will invoke the exception because the denominator is 0.

    }
}
