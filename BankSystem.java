// Main function file
// Testing branch daultons-rules


public class BankSystem {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(1000.00);

        // Create threads simulating multiple users performing transactions concurrently
        TransactionThread t1 = new TransactionThread(sharedAccount, true, 200);
        TransactionThread t2 = new TransactionThread(sharedAccount, false, 150);
        TransactionThread t3 = new TransactionThread(sharedAccount, true, 300);

        // Start the threads
        t1.start();
        t2.start();
        t3.start();
    }
}