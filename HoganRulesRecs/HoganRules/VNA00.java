package HoganRules;

/**
 * This class has code for the rule VNA00 (Ensure visibility when accessing
 * shared primitive variables.)
 * This code example shows two threads that share a primitive variable. The
 * shared variable has the volatile keyword attached to it which allows both
 * threads to immediately see changes that are made to the value. In this
 * example, one thread is changing the shared variable's value while the other
 * is waiting to see if changes are made to the variable. This shows how the
 * volatile keyword ensures visibility among both threads.
 */
public class VNA00 {

    private static volatile int sharedVariable = 0;

    public static void main(String[] args) {
        new ThreadListen().start();
        new ThreadChange().start();
    }

    // This thread stores the shared variable value in a local value. If the shared
    // variable changes, then the thread will see this and enter into its if
    // statement.
    static class ThreadListen extends Thread {
        @Override
        public void run() {
            int currentLocalValue = sharedVariable;
            while (currentLocalValue < 5) {
                if (currentLocalValue != sharedVariable) {
                    System.out.println("The shared variable changed to: " + sharedVariable);
                    currentLocalValue = sharedVariable;
                }
            }
        }
    }

    // This thread modifies the shared variable by incrementing it by 1. This change
    // is seen immediately by the other thread because of the volatile keyword.
    static class ThreadChange extends Thread {
        @Override
        public void run() {
            int currentLocalValue = sharedVariable;
            while (sharedVariable < 5) {
                System.out.println("Incrementing the shared variable to: " + (currentLocalValue + 1));
                sharedVariable = ++currentLocalValue;
                // The thread sleep method is used to stop this thread's execution for a short
                // period of time so the ThreadListen thread can execute and display that it is
                // able to see the shared variable value change.
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
