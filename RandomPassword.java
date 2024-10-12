import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/*
 * This class creates a random password for the user by using the SecureRandom class. 
 * MSC02-J: Generate strong random numbers.
 */
public class RandomPassword {

    // List of all the possible values that can go in the password
    private static final String ALL_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!#$*./?";
    // An instance of the SecureRandom class
    private static final SecureRandom secureRandNum = new SecureRandom();

    /**
     * This method creates a random password using the SecureRandom class.
     * 
     * @return random String password.
     */
    public static void generateRandomPassword(BankAccount account) {

        String[] currentAccountInfo = new String[2];
        currentAccountInfo[0] = account.getName();
        currentAccountInfo[1] = account.getPassword();

        StringBuilder password = new StringBuilder(12);

        for (int i = 0; i < 12; i++) {
            int randomCharIndex = secureRandNum.nextInt(ALL_CHARACTERS.length());
            password.append(ALL_CHARACTERS.charAt(randomCharIndex));
        }

        account.setPassword(password.toString());

        String[] newAccountInfo = new String[2];
        newAccountInfo[0] = account.getName();
        newAccountInfo[1] = account.getPassword();

        /*
         * Comparing the arrays that hold the old user name and password and the new
         * user name and password. Using the Arrays.equals method to compare the
         * contents of the arrays. The password was reset with a random password and
         * the method should return false because the contents in the arrays are not the
         * same.
         * EXP02-J: Do not use the Object.equals() method to compare two arrays.
         */
        if (Arrays.equals(currentAccountInfo, newAccountInfo)) {
            System.out.println("The new password was not set correctly.");
        } else {
            System.out.println(
                    "Your new random password was set successfully. Your new password is: " + account.getPassword());
        }
        // return password.toString();
    }
}