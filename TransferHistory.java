import java.util.ArrayList;
import java.util.List;
public class TransferHistory {
    
    private final List<String> history = new ArrayList<>();

    //Add transfer record to history
    public void addRecord(String record){
        //MET00-J: Validate method arguments
        if(record == null || record.isEmpty()){
            throw new IllegalArgumentException("Record cannot be null or empty.");
        }
        history.add(record);
    }

    public void viewHistory(){
        if(history.isEmpty()){
            System.out.println("No transfer found.");
        }
        else{
            history.forEach(System.out::println);
        }
    }
}
