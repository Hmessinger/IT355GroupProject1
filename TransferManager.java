public final class TransferManager { // MET03-J: Declaring class final to prevent overriding methods that involve transferring funds which is a security sensitive operation
    //Transfer from checking to savings
    public void transferToSavings(BankAccount account, double amount){
        if(account.transferToSavings(amount)){
            System.out.println("Transfer Successful: Checking to Savings");
        }
        else{
            System.out.println("Transfer Failed: Insufficient Funds");
        }
    }

    //Transfer from savings to checking
    public void transferToChecking(BankAccount account, double amount){
        if(account.transferToChecking(amount)){
            System.out.println("Transfer Successful: Savings to CHecking");
        }
        else{
            System.out.println("Transfer Failed: Insufficient Funds");
        }
    }
}
