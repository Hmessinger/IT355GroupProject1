import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * IDS50-J: Use conservative file naming conventions.
 * Description – This recommends using conservative file naming conventions to avoid the use of special characters that might cause unintended behavior. 
 * Filename validation helps prevent path traversal vulnerabilities and ensures cross-platform compatibility.
 * Why is this recommendation important? – It ensures that files names are compatible across platforms, prevents path traversal attacks, and minimizes the chances of filename-based errors.
 */

public class IDS50 {

    // Directory where receipts are stored
    private static final Path RECEIPT_DIR = Paths.get("/path/to/receipts");

    public void generateReceipt(Account account) {
        // Constructing the filename conservatively
        String fileName = RECEIPT_DIR.resolve(account.getAccountNumber() + "-receipt.txt").toString();
        
        // Further processing with the fileName...
        System.out.println("Receipt will be saved as: " + fileName);
    }

    public static void main(String[] args) {
        Account account = new Account("123456"); // Example account number
        IDS50 ids50 = new IDS50();
        ids50.generateReceipt(account);
    }
}

// Example Account class
class Account {
    private String accountNumber;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
