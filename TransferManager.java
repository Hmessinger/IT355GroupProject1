/**
 * The {@code TransferManager} class is responsible for managing secure fund transfers 
 * between checking and savings accounts. The class ensures that critical operations 
 * involving the transfer of funds cannot be overridden, preventing potential security vulnerabilities.
 *
 * MET03-J: Methods that perform a security check must be declared private or final**: 
 * By declaring the class final, this class prevents unauthorized or malicious 
 * overriding of methods that manage security-sensitive operations, such as transferring funds between accounts.
 * 
 * The methods provided in this class ensure the safe and correct transfer of funds 
 * from checking to savings accounts, and vice versa, while providing feedback on the success or failure 
 * of the transfer operation.
 */
public final class TransferManager { // MET03-J: Declaring class final to prevent overriding methods that involve transferring funds which is a security sensitive operation
    // MET03-J: Declaring the class final to prevent overriding methods that involve 
    // transferring funds, a security-sensitive operation.

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
    public void transferToSavings(BankAccount account, double amount){
        if(account.transferToSavings(amount)){
            System.out.println("Transfer Successful: Checking to Savings");
        }
        else{
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
    public void transferToChecking(BankAccount account, double amount){
        if(account.transferToChecking(amount)){
            System.out.println("Transfer Successful: Savings to CHecking");
        }
        else{
            System.out.println("Transfer Failed: Insufficient Funds");
        }
    }
}
