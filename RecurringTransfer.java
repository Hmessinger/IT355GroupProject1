import java.util.Timer;
import java.util.TimerTask;

public final class RecurringTransfer {
    private Timer timer;
    private final TransferManager transferManager;

    public RecurringTransfer(TransferManager transferManager){
        this.transferManager = transferManager;
        initialized(); //Calls non-overridable method (MET05-J)
    }

    private final void initialized(){
        System.out.println("Recurring Transfer initialized");
    }

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

    public void cancelRecurringTransfer() {
        if (timer != null) {
            timer.cancel();
            System.out.println("Recurring transfer cancelled.");
        }
    }

}
