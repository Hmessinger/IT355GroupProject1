import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

/*
 * FIO02-J: Detects and handle file-related errors. 
 * Description – File operations can fail for several reasons. Detecting and handling these errors prevents the program from crashing unexpectedly. 
 * Why is this rule important? –It ensures that the program can recover gracefully from file-related errors. 
 */

public class FIO02J {

    private static final Path RECEIPT_DIR = Path.of("receipts");

    public void processFileOperations(Account account, List<String> transactions) {
        // Attempt to delete a file and handle failure
        File file = new File("file");
        if (!file.delete()) {
            System.err.println("Failed to delete the file.");
        }

        // Handle file writing with error detection
        String fileName = RECEIPT_DIR.resolve(account.getAccountNumber() + "-receipt.txt").toString();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Transaction History Receipt\n");
            writer.write("Account Name: " + account.getName() + "\n");
            writer.write("Account Number: " + account.getAccountNumber() + "\n");
            writer.write("Date: " + new Date() + "\n\n");
            writer.write("Transactions:\n");

            for (String transaction : transactions) {
                writer.write(transaction + "\n");
            }

            writer.write("\nSavings Balance: " + account.getSavingsBalance() + "\n");
            writer.write("Checkings Balance: " + account.getCheckingsBalance() + "\n");
            writer.write("--------------------------------------------\n");

        } catch (IOException e) {
            System.err.println("Error writing receipt: " + e.getMessage());
        }
    }

    // Account is defined elsewhere
    public static class Account {
        private final String name;
        private final String accountNumber;
        private final double savingsBalance;
        private final double checkingsBalance;

        public Account(String name, String accountNumber, double savingsBalance, double checkingsBalance) {
            this.name = name;
            this.accountNumber = accountNumber;
            this.savingsBalance = savingsBalance;
            this.checkingsBalance = checkingsBalance;
        }

        public String getName() {
            return name;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getSavingsBalance() {
            return savingsBalance;
        }

        public double getCheckingsBalance() {
            return checkingsBalance;
        }
    }
}
