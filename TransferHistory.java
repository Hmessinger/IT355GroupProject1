import java.util.ArrayList;
import java.util.List;

/**
 * The {@code TransferHistory} class manages a collection of transfer records,
 * ensuring proper validation and security practices are followed. This class 
 * provides functionality for adding new transfer records and viewing the 
 * entire transaction history while maintaining data integrity.
 * ENV04-J: Do not disable bytecode verification**: This class uses standard Java 
 * language features and access controls (such as private fields and methods). 
 * By adhering to secure coding guidelines and not bypassing or disabling JVM bytecode 
 * verification, this class ensures that the JVM’s security checks, such as ensuring 
 * type safety, are not compromised.</li>
 * 
 * The bytecode verification enforced by the JVM ensures that this class remains 
 * type-safe, adheres to access control, and follows defined security rules, making it 
 * resilient to potential exploits like type confusion or illegal memory access.
 */
public class TransferHistory {
    //This class has MET00 and ENV04
    private final List<String> history = new ArrayList<>();

/**
 * Adds a new record to the transaction history.
 *
 * <p>This method ensures that the provided record is valid before adding it to the history. 
 * It checks if the input string is null or empty, and if either condition is met, 
 * it throws an {@code IllegalArgumentException} to prevent invalid data from being added.
 *
 * <p>Compliance with the MET00-J (Validate Method Arguments) rule:
 * This method adheres to the MET00-J rule by validating the `record` parameter to ensure
 * it is not null or an empty string. This prevents the method from processing invalid
 * or incomplete input, thereby ensuring that the program behaves correctly and securely.
 * 
 * @param record the record to be added to the transaction history
 * @throws IllegalArgumentException if the record is null or empty
 */
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
