import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * ERR54-J: Use a try-with-resources statement to safely handle closeable resources.
 * Description – This recommendation ensures that any resources implementing AutoCloseable (ex: streams) are properly closed to avoid resource leaks. The try-with-resources statement ensures that resources are closed automatically, even if an exception occurs.
 * Why is this recommendation important? – It prevents resource leaks and ensures that system resources such as file handles are released promptly.
 */

public class ERR54 {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        String fileName = "transaction_history.txt";

        // Acquire the lock before writing to the file
        lock.lock();
        try {
            /*
            * This code uses the try-with-resources construct to manage BufferedWriter       * instances, ensuring that file streams are closed properly.
            */
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write("Transaction History Receipt\n");
            } catch (IOException e) {
                System.err.println("Error writing receipt: " + e.getMessage());
            }
        } finally {
            // Ensure the lock is released on exceptional conditions
            lock.unlock();
        }
    }
}
