import java.io.IOException;

/**
 * TSM03-J: Do not publish partially initialized objects.
 * Description – Returning partially initialized objects can lead to undefined behavior if other parts of the system try to use them.
 * Why is this rule important? – It ensures that only fully initialized objects are available, preventing runtime errors.
 */

public class TSM03J {
    private Helper helper;

    public synchronized Helper getHelper() {
        return helper;
    }

    public synchronized void initialize() {
        helper = new Helper(42);
    }

    /**
     * The factory method ensures that TransactionHistory is only returned when fully initialized.
     */
    public static TransactionHistory createSafely() {
        try {
            return new TransactionHistory();
        } catch (IOException e) {
            System.err.println("Error initializing TransactionHistory: " + e.getMessage());
            return null;
        }
    }

    // Helper is defined elsewhere
    public static class Helper {
        private final int value;

        public Helper(int value) {
            this.value = value;
        }

        // Additional methods for Helper
    }

    // TransactionHistory is defined elsewhere
    public static class TransactionHistory {
        public TransactionHistory() throws IOException {
            // Initialization logic that might throw IOException
        }

        // Additional methods for TransactionHistory
    }
}
