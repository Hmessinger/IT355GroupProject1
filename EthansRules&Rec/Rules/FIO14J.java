import java.io.*;
import java.nio.file.*;

/*
 * FIO014-J: Perform proper cleanup at program termination. 
 * Description – Temporary files should be removed before the program terminates to avoid leaving sensitive data exposed. 
 * Why is this rule important? – This rule ensures that temporary data is not left accessible after the program ends. 
 */

public class FIO14J {

    private static final Path RECEIPT_DIR = Paths.get("receipts");

    public static void main(String[] args) {
        try (PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("foo.txt")))) {
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                out.close();
                System.out.println("Resources have been cleaned up.");
            }));

            out.println("hello");
            // Avoid using exit to ensure the shutdown hook runs naturally
        } catch (FileNotFoundException e) {
            System.err.println("Error opening file: " + e.getMessage());
        }

        // Perform cleanup of old receipts
        new FIO14J().cleanupOldReceipts();
    }

    /* 
    * The cleanupOldReceipts() method removes old receipt files properly. 
    */ 
    public void cleanupOldReceipts() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(RECEIPT_DIR)) {
            for (Path entry : stream) {
                Files.deleteIfExists(entry); // Delete each receipt file
            }
            System.out.println("Old receipts have been cleaned up.");
        } catch (IOException e) {
            System.err.println("Error deleting old receipts: " + e.getMessage());
        }
    }
}
