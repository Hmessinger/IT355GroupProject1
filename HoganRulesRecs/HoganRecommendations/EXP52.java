package HoganRecommendations;

/**
 * This class has code for the recommendation EXP52 (Use braces for the body of
 * an if, for, or while statement).
 * This code shows a simple nested if-else statement that uses braces to help
 * with code clarity and readability.
 */
public class EXP52 {

    public static void main(String[] args) {
        int i1 = 20;
        int i2 = 100;

        if (i1 == 20) {
            if (i2 == 100) {
                System.out.println("The int values are equal to the specified values.");
            } else {
                System.out.println("The second int value is not equal to 100.");
            }
        } else {
            System.out.println("The first int value is not equal to 20.");
        }
    }
}
