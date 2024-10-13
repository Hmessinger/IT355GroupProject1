package HoganRules;

import java.io.File;

/**
 * This class has code for the rule EXP00 (Do not ignore values returned by
 * methods).
 * This code deletes the file textfile.txt from the project and it uses the
 * output of the delete method to display a message to the screen. It doesn't
 * ignore the output of the delete method.
 */
public class EXP00 {
    public static void main(String[] args) {
        File file = new File("textfile.txt");

        // Checking and using the return value, rather than ignoring it
        boolean isDeleted = file.delete();
        if (!isDeleted) {
            System.out.println("Error: Could not delete the file.");
        } else {
            System.out.println("File deleted successfully.");
        }
    }
}