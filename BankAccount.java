class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Synchronized methods to ensure thread safety
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount);
        System.out.println("New Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to withdraw: " + amount + " (Insufficient funds)");
        }
    }
}

class TransactionThread extends Thread {
    private final BankAccount account;
    private final boolean isDeposit;
    private final double amount;

    public TransactionThread(BankAccount account, boolean isDeposit, double amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}
