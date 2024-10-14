import java.io.*;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LCK08-J: Ensure actively held locks are released on exceptional conditions.
 * Description – Locks should always be released, even when exceptions occur, to prevent deadlocks.
 * Why is this rule important? – It ensures that threads do not get stuck waiting for a lock that is never released.
 */

public class LCK08J {
    public final class Client {
        private final Lock lock = new ReentrantLock();

        public void doSomething(File file) {
            InputStream in = null;
            lock.lock();
            try {
                in = new FileInputStream(file);
                // Perform operations with the input stream
            } catch (FileNotFoundException fnf) {
                // Handle exception
            } finally {
                lock.unlock(); // Ensure the lock is released

                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        // Handle exception
                    }
                }
            }
        }

        public void generateReceipt(BankAccount account, List<String> transactions) {
            lock.lock();
            try {
                // Logic for generating receipt
            } finally {
                lock.unlock(); // Ensure the lock is released
            }
        }
    }
    
    // BankAccount is defined elsewhere
    public static class BankAccount {
        // BankAccount implementation
    }
}
