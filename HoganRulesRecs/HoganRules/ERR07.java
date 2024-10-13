package HoganRules;

import java.io.FileNotFoundException;

/**
 * This class has code for the rule ERR07 (Do not throw Runtime Exception,
 * Exception, or Throwable).
 * This code checks to see if a string has the letter e in it. If the string
 * that is given is null, then the program throws a NullPointerException instead
 * of just the broad Exception.
 */
public class ERR07 {

    public static void main(String[] args) {
        String word = "hello";
        String word2 = null;
        System.out.println(isThereAnE(word));
        System.out.println(isThereAnE(word2));
    }

    // Method for checking if the string argument has the letter e in it.
    // Throws a NullPointerException if the string is null.
    private static boolean isThereAnE(String name) {
        if (name == null) {
            throw new NullPointerException("The string given was null.");
        }
        if (name.equals("")) {
            return false;
        }
        return name.contains("e");
    }
}
