/*
* LCK01-J: Do not synchronize on objects that may be reused. 
* Description – Synchronizing on shared or reused objects can lead to deadlocks or race conditions.
* Using a dedicated lock object ensures safe concurrency management. 
* Why is this rule important? – It ensures that synchronization is done in a way that avoids contention and deadlock risks. 
 */

import java.util.concurrent.locks.ReentrantLock;

public class LCK01J {
    private int count = 0;

    // Using ReentrantLock to ensure concurrency management.
    private static final ReentrantLock reentrantLock = new ReentrantLock();

    public void doSomethingWithReentrantLock() {
        reentrantLock.lock();
        try {
            count++;
        } finally {
            reentrantLock.unlock();
        }
    }
}
