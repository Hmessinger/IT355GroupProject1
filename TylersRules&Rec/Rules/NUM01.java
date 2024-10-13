package Rules;

public class NUM01 {
    
    public int safeOperations(int a, int b){
        int sum = a + b; //Arithmetic operation
        int mask = 0xFF; //Bitwise mask
        int result = sum & mask; //Bitwise AND applied after arithmetic

        return result;
    }
}
