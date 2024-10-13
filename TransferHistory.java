import java.util.ArrayList;
import java.util.List;

public class TransferHistory {
    //This class has MET00 and ENV04
    private final List<String> history = new ArrayList<>();

    // Add transfer record to history
    public void addRecord(String record) {
        // MET00-J: Validate method arguments
        if (record == null || record.isEmpty()) {
            throw new IllegalArgumentException("Record cannot be null or empty.");
        }
        history.add(record);
    }

    /**
     * In this method, rather than returning the private mutable history List, we
     * create a copy of it and return the copied List. This method will return the
     * list even if it is an empty list.
     * This method implements the following rules and recommendations:
     * OBJ05-J: Do not return references to private mutable class members.
     * MET55-J: Return an empty array or collection instead of a null value for the
     * methods that return an array or collection.
     */
    public List<String> viewHistory() {
        return new ArrayList<>(history);

        // if (history.isEmpty()) {
        // System.out.println("No transfer found.");
        // } else {
        // history.forEach(System.out::println);
        // }
    }
}
