import java.io.*;

/**
 * FIO08-J: Distinguish between characters or bytes read from a stream and -1. 
 * Description – The value -1 indicated the end of a stream. Proper handling of this value ensures that streams are read correctly. 
 * Why is this rule important? – It ensures that the program correctly identifies the end of streams and prevents data corruption. 
 */

public class FIO08J {

    public void readFromFile(String fileName) {
        try (FileInputStream in = new FileInputStream(fileName)) {
            int inbuff;
            byte data;

            while ((inbuff = in.read()) != -1) {
                data = (byte) inbuff;
                // Process the data byte
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    public void writeToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Transaction History Receipt\n");
            // Additional writing logic can be added here
        } catch (IOException e) {
            System.err.println("Error writing receipt: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FIO08J fio08j = new FIO08J();

        // Example usage of readFromFile and writeToFile methods
        fio08j.readFromFile("input.txt");
        fio08j.writeToFile("receipt.txt");
    }
}
