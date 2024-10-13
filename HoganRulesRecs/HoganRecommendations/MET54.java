package HoganRecommendations;

/**
 * This class has code for the recommendation MET54 (Always provide feedback
 * about the resulting value of a method).
 * The increaseCounterIfValueIsPositive method will increase the counter
 * variable if the int value argument is positive and won't do anything to the
 * counter otherwise. The method will return true if the counter is increased
 * and false if it isn't. The method returns a boolean value to provide feedback
 * for the method result.
 */
public class MET54 {

    private static int counter = 0;

    private static boolean increaseCounterIfValueIsPosititive(int number) {
        if (number < 0) {
            return false;
        } else {
            counter++;
            return true;
        }
    }

    public static void main(String[] args) {
        int num1 = -4;
        int num2 = 2;

        System.out.println("Counter: " + counter);
        System.out.println(increaseCounterIfValueIsPosititive(num1));
        System.out.println("Counter: " + counter);
        System.out.println(increaseCounterIfValueIsPosititive(num2));
        System.out.println("Counter: " + counter);
    }
}
