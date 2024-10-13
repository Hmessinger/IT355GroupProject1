package HoganRules;

import java.security.SecureRandom;

/**
 * This class has code for the rule MSC02 (Generate strong random numbers).
 * The generateRandomNum method creates a secure random integer using the
 * secure number generator class SecureRandom. The method uses an upperbound
 * that is given as an argument.
 */
public class MSC02 {

    private static int generateRandomNum(int upperBound) {
        SecureRandom secureRandNum = new SecureRandom();
        // Create a random double that is secure
        return secureRandNum.nextInt(upperBound);
    }

    public static void main(String args[]) {
        System.out.println(generateRandomNum(1000));
        System.out.println(generateRandomNum(50));
    }
}
