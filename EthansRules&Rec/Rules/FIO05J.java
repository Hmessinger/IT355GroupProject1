import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;

/**
 * FIO05-J: Do not expose buffers or their backing arrays to untrusted code. 
 * Description – Exposing internal buffers can allow external code to modify or access private data, leading to security vulnerabilities. 
 * Why is this rule important? – The rule ensures that private data is not leaked through buffer exposure. 
 */

public class FIO05J {

    final class Wrap {
        private char[] dataArray;

        public Wrap() {
            dataArray = new char[10];
            // Initialize dataArray with some values
        }

        // Provide a read-only view of the buffer
        public CharBuffer getBufferCopy() {
            return CharBuffer.wrap(dataArray).asReadOnlyBuffer();
        }
    }

    // Method to generate a receipt without exposing internal buffers
    public void generateReceipt(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Transaction History Receipt\n");
            // Additional writing logic
        } catch (IOException e) {
            System.err.println("Error writing receipt: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FIO05J fio05j = new FIO05J();
        Wrap wrap = fio05j.new Wrap();

        // Generate receipt
        fio05j.generateReceipt("receipt.txt");

        // Accessing the buffer copy safely
        CharBuffer bufferCopy = wrap.getBufferCopy();
        // Perform read operations on bufferCopy
    }
}
