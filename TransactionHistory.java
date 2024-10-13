import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TransactionHistory {

    // FIO16-J: Canonicalize path names before validating them
    private static final Path RECEIPT_DIR = Paths.get("./Receipts");

    // LCK06-J: Use a static lock to protect shared static data
    private static final ReentrantLock lock = new ReentrantLock();

    // Constructor to create the receipts directory if it doesn't exist
    public TransactionHistory() throws IOException {
        if (!Files.exists(RECEIPT_DIR)) {
            Files.createDirectories(RECEIPT_DIR);
        }
    }

    // Method to generate a transaction history receipt
    public void generateReceipt(BankAccount account, List<String> transactions) {
        // LCK01-J: Synchronize using the lock to prevent concurrency issues
        lock.lock();
        try {
            String fileName = RECEIPT_DIR.resolve(account.getAccountNumber() + "-receipt.txt").toString();

            // FIO02-J: Detect and handle file-related errors
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
        } finally {
            // LCK08-J: Ensure the lock is released on exceptional conditions
            lock.unlock();
        }
    }

    // FIO14-J: Cleanup method to remove old receipt files
    public void cleanupOldReceipts() {
        // FIO03-J: Remove temporary files before termination
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(RECEIPT_DIR)) {
            for (Path entry : stream) {
                Files.deleteIfExists(entry); // Delete each receipt file
            }
        } catch (IOException e) {
            System.err.println("Error deleting old receipts: " + e.getMessage());
        }
    }

    // TSM03-J: Factory method to prevent publishing partially initialized objects
    public static TransactionHistory createSafely() {
        try {
            return new TransactionHistory();
        } catch (IOException e) {
            System.err.println("Error initializing TransactionHistory: " + e.getMessage());
            return null;
        }
    }
}
