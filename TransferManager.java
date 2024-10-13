/**
 * The {@code TransferManager} class is responsible for managing secure fund transfers 
 * between checking and savings accounts. The class ensures that critical operations 
 * involving the transfer of funds cannot be overridden, preventing potential security vulnerabilities.
 *
 * MET03-J: Methods that perform a security check must be declared private or final**: 
 * By declaring the class final, this class prevents unauthorized or malicious 
 * overriding of methods that manage security-sensitive operations, such as transferring funds between accounts.
 * 
 * MET05-J: Ensure that constructors call non-overrideable methods.
 * 
 * The methods provided in this class ensure the safe and correct transfer of funds 
 * from checking to savings accounts, and vice versa, while providing feedback on the success or failure 
 * of the transfer operation.
 */
public final class TransferManager {
    
    /**
     * The constructor of the {@code TransferManager} class.
     * 
     * MET05-J: The constructor initializes secure operations or setup and calls 
     * a final method to confirm initialization.
     */
    public TransferManager() {
        // Call a non-overridable (final) method to initialize or perform a setup task
        initializeManager();
    }

    /**
     * Initialize the TransferManager.
     * 
     * This method is declared final to prevent overriding, ensuring that the initialization
     * is always secure and consistent. It is called in the constructor to adhere to MET05-J.
     */
    private final void initializeManager() {
        // Any setup logic can go here. For now, let's just print an initialization message.
        System.out.println("TransferManager initialized. Secure fund transfers are ready.");
    }

    /**
     * Transfers funds from the checking account to the savings account.
     *
     * <p>This method calls the {@code transferToSavings} method on the provided
     * {@code BankAccount} object to attempt a fund transfer from the checking account 
     * to the savings account. If the transfer is successful, it prints a success message;
     * otherwise, it prints a failure message indicating insufficient funds.
     *
     * @param account the bank account from which to transfer funds
     * @param amount the amount of money to transfer
     */
    public final void transferToSavings(BankAccount account, double amount) {
        if (account.transferToSavings(amount)) {
            System.out.println("Transfer Successful: Checking to Savings");
            System.out.println("New balance of Savings account: " + "$" + account.getSavingsBalance());
            System.out.println("New balance of Checking Account: " + "$" + account.getCheckingsBalance());
        } else {
            System.out.println("Transfer Failed: Insufficient Funds");
        }
    }

   /**
     * Transfers funds from the savings account to the checking account.
     *
     * <p>This method calls the {@code transferToChecking} method on the provided
     * {@code BankAccount} object to attempt a fund transfer from the savings account 
     * to the checking account. If the transfer is successful, it prints a success message; 
     * otherwise, it prints a failure message indicating insufficient funds.
     *
     * @param account the bank account from which to transfer funds
     * @param amount the amount of money to transfer
     */
    public final void transferToChecking(BankAccount account, double amount) {
        if (account.transferToChecking(amount)) {
            System.out.println("Transfer Successful: Savings to Checking");
            System.out.println("New balance of Checking account: " + "$" + account.getCheckingsBalance());
            System.out.println("New balance of Savings Account: " + "$" + account.getSavingsBalance());
        } else {
            System.out.println("Transfer Failed: Insufficient Funds");
        }
    }
}

