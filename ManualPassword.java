
/**
 * This class allows the user to enter in a manually generated password.
 * The method for setting the user password implements the two rules listed
 * below:
 * MET01-J: Never use assertions to validate method arguments.
 * ERR07-J: Do not throw Runtime Exception, Exception, or Throwable.
 * 
 * The method doesn't use assertions to validate the password argument, rather
 * it throws an IllegalArgumentException to perform validation.
 */
public class ManualPassword {

    /**
     * This method lets the user change their password.
     * 
     * @param account     - the account that we are changing the password for.
     * @param newPassword - The new password created by the user.
     */
    public void generateManualPassword(BankAccount account, String newPassword) {

        try {
            if (newPassword.equals(null) || newPassword.equals("")) {
                throw new IllegalArgumentException("The password must not be null or empty.");
            } else {
                account.setPassword(newPassword);
                System.out.println(
                        "Your password was successfully changed. Your current password is: " + account.getPassword());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Caught an IllegalArgumentException: The password can not be null or empty.");
        }
    }

}