import java.util.concurrent.locks.ReentrantLock;

/**
 * LCK06-J: Do not use an instance lock to protect shared static data.
 * Description – Using an instance-level lock for shared static data can cause inconsistent behavior, especially in multithreaded environments.
 * Why is this rule important? – This rule ensures that shared static data is accessed safely without conflicting between different threads.
 */

public class LCK06J implements Runnable {
    private static int counter;
    // Use a single static ReentrantLock for managing concurrent access
    private static final ReentrantLock lock = new ReentrantLock();

    public void run() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }
}
