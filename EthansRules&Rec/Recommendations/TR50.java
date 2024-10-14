import java.util.Scanner;

/*
 * TR50-J: Use the appropriate method for counting characters in a string.
 * Description – This recommendation emphasizes using appropriate methods for counting characters, such as consideringUnicode and surrogate pairs. Using string length methods incorrectly can lead to inaccurate results, especially with non-ASCII characters.
 * Why is this recommendation important? – It ensures that strings are counted accurately, accounting for Unicode and multi-byte characters, which prevents potential logical errors.
 */

public class TR50 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userPassword;

        while (true) {
            System.out.println("\nPlease input the account password: ");
            userPassword = scan.nextLine();

            if (userPassword != null && !userPassword.isEmpty()) {
                // Use codePointCount to accurately count characters
                int charCount = userPassword.codePointCount(0, userPassword.length());
                
                if (charCount < 8) {
                    System.out.println("Password must contain at least 8 characters.");
                } else {
                    System.out.println("Password accepted.");
                    break;
                }
            } else {
                System.out.println("Invalid input. Please enter a password that is not empty.");
            }
        }

        scan.close();
    }
}
