
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

class BankAccount {

    private final String name;
    private final int customerId;
    private final int accountNumber;
    private double savingsBalance;
    private double checkingsBalance;
    private String password;

    // NUM10-J. Do not construct BigDecimal objects from floating-point literals
    private BigDecimal intrestRate = new BigDecimal("0.000000001");

    // Constructor
    public BankAccount(String name, int customerId, int accountNumber, double savingsBalance, double checkingsBalance) {
        this.checkingsBalance = checkingsBalance;
        this.savingsBalance = savingsBalance;
        this.accountNumber = accountNumber;
        this.name = name;
        this.customerId = customerId;
    }

    // Overloaded Constructor
    public BankAccount(String name, int customerId, int accountNumber, double savingsBalance, double checkingsBalance,
            String password) {
        this.checkingsBalance = checkingsBalance;
        this.savingsBalance = savingsBalance;
        this.accountNumber = accountNumber;
        this.name = name;
        this.customerId = customerId;
        this.password = password;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public void setCheckingsBalance(double checkingsBalance) {
        this.checkingsBalance = checkingsBalance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public double getCheckingsBalance() {
        return checkingsBalance;
    }

    public String getPassword() {
        return password;
    }

    // MET09-J: Classes that define an equals() method must also define a hashCode()
    // method
    @Override
    public boolean equals(Object accountObject) {
        if (this == accountObject) {
            return true;
        }
        if (accountObject == null || getClass() != accountObject.getClass()) {
            return false;
        }
        BankAccount account = (BankAccount) accountObject;
        return customerId == account.customerId && accountNumber == account.accountNumber;
    }

    // MET09-J: Classes that define an equals() method must also define a hashCode()
    // method
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, customerId);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n"
                + "Customer Id: " + this.customerId + "\n"
                + "Account Number: " + this.accountNumber + "\n"
                + "Savings Balance: " + this.savingsBalance + "\n"
                + "Checkings Balance " + this.checkingsBalance + "\n\n";
    }

    // MSC04-J: Do not leak memory
    // Keeping a file open for too long can lead to memory leaks because file
    // handles (system resources) are limited,
    // and each open file consumes memory.
    public void createAccountLogFile() throws IOException {
        BankAccount.clearAccountLogFile();

        // FIO16-J. Canonicalize path names before validating them
        Path dirPath = Paths.get("./AccountsCreated");

        // Create the directory if it does not exist
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        String fileName = dirPath.resolve(this.accountNumber + "-logfile.txt").toString();

        try (FileOutputStream fos = new FileOutputStream(fileName, true);
                DataOutputStream dos = new DataOutputStream(fos)) {

            // FIO09-J. Do not rely on the write() method to output integers outside the
            // range 0 to 255
            dos.writeInt(this.accountNumber);
        } catch (IOException e) {
        }
    }

    // FIO03-J. Remove temporary files before termination
    public static void clearAccountLogFile() {
        String dirPath = "./AccountsCreated";
        Path directory = Paths.get(dirPath);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path entry : stream) {
                Files.deleteIfExists(entry); // Deletes each entry if it exists
            }
        } catch (IOException e) {
        }
    }
}

class MassAccountCreate {

    public void createAccountsUsingFile(String inputFileName) {

        // MET12-J: Do not use finalizers
        // The code avoids using finalizers by leveraging the try-with-resources
        // construct.
        // Try-with-resources block automatically handles resource management for any
        // object
        try (FileInputStream inputFile = new FileInputStream(inputFileName);
                InputStreamReader inputStreamReader = new InputStreamReader(inputFile);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            ArrayList<BankAccount> accounts = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");

                try {

                    int customerId = Integer.parseInt(words[1]);
                    int accountNumber = Integer.parseInt(words[2]);
                    double savingsBalance = Double.parseDouble(words[3]);
                    double checkingsBalance = Double.parseDouble(words[4]);

                    accounts.add(
                            new BankAccount(words[0], customerId, accountNumber, savingsBalance, checkingsBalance));

                } catch (NumberFormatException e) {
                    System.out.println("Error parsing number: " + e.getMessage());
                }

            }

            int size = accounts.size();
            System.out.print("Accounts Created from file\n");

            // NUM09-J. Do not use floating-point variables as loop counters
            // MSC01-J: Do not use an empty infinite loop
            for (int i = 0; i < size; i++) {
                System.out.print(accounts.get(i));
                accounts.get(i).createAccountLogFile();
            }

        } catch (IOException e) {

        }
    }
}
