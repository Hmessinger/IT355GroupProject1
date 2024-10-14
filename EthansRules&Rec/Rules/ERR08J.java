/**
* ERR08: Do not catch NullPointerException or any of its ancestors. 
* Description – This rule advises against catching NullPointerException or related exceptions.
* These exceptions usually indicate a deeper issue, such as improper input handling or uninitialized objects. 
* Catching them can mask real problems and lead to unpredictable behavior. 
* Why is this rule important? – Proper input validation helps prevent null references, which ensures more stable code and avoids masking underlying issues.  
*/

import java.util.Scanner;
/* 
* The code avoids catching NullPointerException.
* Instead, input validation *is performed to prevent null references. 
*/ 
public class ERR08J {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userName;

        while (true) {
            System.out.println("Please input the customer name: ");
            userName = scan.nextLine();

            if (userName != null && !userName.isEmpty()) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a name that is not empty.");
            }
        }

        System.out.println("Customer name entered: " + userName);
        scan.close();
    }
}
