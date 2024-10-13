import java.util.Timer;
import java.util.TimerTask;

/**
 * The class manages recurring fund transfers 
 * between a bank account and savings. It utilizes a timer to 
 * execute transfers at specified intervals.
 * This class is designed to be immutable and final to prevent 
 * subclassing, ensuring consistent behavior. It includes functionality 
 * to set and cancel recurring transfers.
 */
public final class RecurringTransfer {
    private Timer timer;
    private final TransferManager transferManager;

/**
 * Constructs a RecurringTransfer instance with the specified TransferManager
 * MET05
 * @param transferManager the TransferManager responsible for handling transfers
 */
    public RecurringTransfer(TransferManager transferManager){
        this.transferManager = transferManager;
        initialized(); //Calls non-overridable method (MET05-J)
    }

    /**
     * Initializes the recurring transfer process, printing an initialization message.
     */
    private final void initialized(){
        System.out.println("Recurring Transfer initialized");
    }

    /**
     * Sets up a recurring transfer of a specified amount to savings from the 
     * given bank account at a fixed interval.
     *
     * <p>This method validates the interval and schedules the transfer using 
     * a {@code Timer}. The transfer will occur at the specified interval 
     * in milliseconds.</p>
     *
     * @param account the {@code BankAccount} from which funds will be transferred
     * @param amount the amount to transfer to savings
     * @param intervalMs the interval in milliseconds for the recurring transfer
     * @throws IllegalArgumentException if {@code intervalMs} is less than or equal to 0
     */
    public void setRecurringTransferToSavings(BankAccount account, double amount, long intervalMs){
        // MET00-J: Validate method arguments
        if (intervalMs <= 0) {
            throw new IllegalArgumentException("Interval must be greater than 0.");
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                transferManager.transferToSavings(account, amount);
            }
        }, 0, intervalMs); // Schedule at a fixed interval
    }
/**
 * Cancels an ongoing recurring transfer, if one exists.
 *
 * <p>This method checks if the {@code timer} object, responsible for scheduling
 * recurring transfers, is not {@code null}. If the timer is active, it cancels
 * the scheduled transfer and prints a confirmation message to the console.
 * 
 * <p>This method ensures that no further automatic transfers will be made once
 * the timer is cancelled.
 * 
 * @throws IllegalStateException if there is no recurring transfer scheduled (i.e., {@code timer} is {@code null}).
 */
    public void cancelRecurringTransfer() {
        if (timer != null) {
            timer.cancel();
            System.out.println("Recurring transfer cancelled.");
        }
    }

}
