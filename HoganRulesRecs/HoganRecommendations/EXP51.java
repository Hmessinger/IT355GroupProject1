package HoganRecommendations;

/**
 * This class has code for the recommendation EXP51-J (Do not perform
 * assignments in conditional expressions).
 * The code shows an example of a conditional expression that does not perform
 * an assignment in it.
 */
public class EXP51 {

    /**
     * Code for EXP51-J.
     * Method for comparing two ints using a conditional expression.
     * 
     * @param data1
     * @param data2
     * @return true if the data values are equal and false otherwise
     */
    private boolean conditionalCompare(int data1, int data2) {
        if (data1 == data2) {
            return true;
        } else {
            return false;
        }
    }
}