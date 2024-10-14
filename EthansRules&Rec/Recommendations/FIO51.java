import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * FIO51-J: Identify files using multiple file attributes.
 * Description – This recommendation advises using multiple attributes to identify files uniquely, as relying on just the filename or path can lead to errors or inconsistencies such as stale paths.
 * Why is this recommendation important? – Using multiple attributes ensures the integrity and correctness of file operations, avoiding situations where the wrong file might be referenced.
 */

public class FIO51 {
    private static final Path RECEIPT_DIR = Path.of("receipts");
    private static final Logger logger = Logger.getLogger(FIO51.class.getName());

    public void cleanupOldReceipts() {
        /*
        * This code uses DirectoryStream for safe file iteration and uses a specified directory to identify files.
        */

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(RECEIPT_DIR)) {
            for (Path entry : stream) {
                try {
                    BasicFileAttributes attrs = Files.readAttributes(entry, BasicFileAttributes.class);
                    
                    // Example condition: delete if file is older than 30 days
                    long currentTime = System.currentTimeMillis();
                    long fileAge = currentTime - attrs.creationTime().toMillis();
                    long thirtyDaysInMillis = 30L * 24 * 60 * 60 * 1000;

                    if (fileAge > thirtyDaysInMillis) {
                        Files.deleteIfExists(entry); // Delete each receipt file
                        logger.log(Level.INFO, "Deleted old receipt: {0}", entry.getFileName());
                    }
                } catch (IOException e) {
                    logger.log(Level.SEVERE, "Error reading attributes or deleting file: {0}", entry.getFileName());
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error accessing directory: {0}", e.getMessage());
        }
    }

    public static void main(String[] args) {
        new FIO51().cleanupOldReceipts();
    }
}
