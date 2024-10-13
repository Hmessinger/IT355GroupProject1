
// Main function file
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class BankSystem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userName;
        String userPassword;
        int userCustomerID;
        int userAcctNum;
        double initialCheckingDeposit;
        double initialSavingsDeposit;

        // Transaction Constructor
        TransactionHistory transactionHistory = TransactionHistory.createSafely();
        if (transactionHistory == null) {
            System.err.println("Failed to initialize TransactionHistory");
            return;
        }
    
        List<String> transactions = new ArrayList<>();
        

        /*
         * We are performing validation checks on the user input before it is being used
         * by the BankAccount constructor. This prevents the constructor from throwing
         * an exception and partially creating an object. This follows the rule:
         * OBJ11-J: Be wary of letting constructors throw exceptions.
         */
        // Asks for users name
        // System.out.println("Please input the customer name: ");
        // String userName = scan.nextLine();
        while (true) {
            System.out.println("Please input the customer name: ");
            userName = scan.nextLine();
            if (userName != null && !userName.isEmpty()) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a name that is not empty.");
            }
        }

        // Asks for the users customer id
        // System.out.println("\nPlease input the customer ID: ");
        // int userCustomerID = scan.nextInt();
        // Asks for the users customer id, it will loop until a valid integer is entered
        while (true) {
            System.out.println("\nPlease input the customer ID: ");

            // Check if the next input is an integer
            if (scan.hasNextInt()) {
                userCustomerID = scan.nextInt(); // If valid, read the integer
                scan.nextLine();
                break; // Exit the loop if input is valid
            } else {
                System.out.println("Invalid input. Please enter a valid integer for the customer ID.");
                scan.next();
            }
        }

        // Asks for the account number
        // System.out.println("\nPlease input the account number: ");
        // int userAcctNum = scan.nextInt();
        // Asks for the account number, it will loop until a valid integer is entered
        while (true) {
            System.out.println("\nPlease input the account number: ");

            // Check if the next input is an integer
            if (scan.hasNextInt()) {
                userAcctNum = scan.nextInt(); // If valid, read the integer
                scan.nextLine();
                break; // Exit the loop if input is valid
            } else {
                System.out.println("Invalid input. Please enter a valid integer for the account number.");
                scan.next();
            }
        }

        // System.out.println("\nPlease input the account password: ");
        // String userPassword = scan.next();
        // Ask for the account password, it will loop until a valid password is entered
        while (true) {
            System.out.println("\nPlease input the account password: ");
            userPassword = scan.nextLine();
            if (userPassword != null && !userPassword.isEmpty()) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a password that is not empty.");
            }
        }

        // System.out.println("\nPlease input initial deposit for checking account: ");
        // double initialCheckingDeposit = scan.nextDouble();
        // Ask for the initial checking deposit, it will loop until a valid amount is
        // entered
        while (true) {
            System.out.println("\nPlease input the initial deposit for checking account: ");
            // Check if the next input is a valid double
            if (scan.hasNextDouble()) {
                initialCheckingDeposit = scan.nextDouble();
                // Check to make sure the deposit is non-negative.
                if (initialCheckingDeposit >= 0) {
                    scan.nextLine();
                    break;
                } else {
                    System.out.println("Invalid input. The deposit cannot be negative value.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number for the initial deposit.");
                scan.next();
            }
        }

        // System.out.println("\nPlease input initial deposit for savings account: ");
        // double initialSavingsDeposit = scan.nextDouble();
        // Ask for the initial savings deposit, it will loop until a valid amount is
        // entered
        while (true) {
            System.out.println("\nPlease input the initial deposit for savings account: ");
            // Check if the next input is a valid double
            if (scan.hasNextDouble()) {
                initialSavingsDeposit = scan.nextDouble();
                // Check to make sure the deposit is non-negative.
                if (initialSavingsDeposit >= 0) {
                    scan.nextLine();
                    break;
                } else {
                    System.out.println("Invalid input. The deposit cannot be negative value.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number for the initial deposit.");
                scan.next();
            }
        }

        try {
            BankAccount account = new BankAccount("Ethan", 1, 123456, 1000.00, 500.00);

            // Use factory method to create TransactionHistory safely
            TransactionHistory transactionHistory = TransactionHistory.createSafely();

            if (transactionHistory != null) {
                List<String> transactions = List.of("Deposit: $500", "Withdrawal: $200","Transfer to Account 654321: $100");

                // Generate a receipt for the transactions
                transactionHistory.generateReceipt(account, transactions);

                // Cleanup old receipts
                transactionHistory.cleanupOldReceipts();
            }
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }


        CurrencyExchange currencyExchange = new CurrencyExchange();

        // Account Constructor
        BankAccount account = new BankAccount(userName, userCustomerID, userAcctNum, initialCheckingDeposit,
                initialSavingsDeposit, userPassword);

        System.out.print("\nAccount created successfully!\n");
        System.out.print(account);

        System.out.println("\n     Bank Menu");
        System.out.println("======================");

        // Loop is working correctly
        int choice = 0;
        while (choice != 9) {
            System.out.println("1:Deposit");
            System.out.println("2:Withdraw");
            System.out.println("3:Display Account");
            System.out.println("4:Manually Change Password");
            System.out.println("5:Generate Random Password");
            System.out.println("6:Transaction History");
            System.out.println("7:Currency Conversion");
            System.out.println("8:Transfer Funds");
            System.out.println("9: Exit");

            System.out.println("Please input your choice <1-9>");
            choice = scan.nextInt();
            System.out.println("You selected: " + choice);

            if (choice == 1) {

            }

            if (choice == 2) {

            }

            if (choice == 3) {
                System.out.println("\nYour account info:");
                System.out.println(account);
            }

            if (choice == 4) {

            }

            if (choice == 5) {

            }

            if (choice == 6) {
                System.out.println("\nYour transaction history:");
                transactionHistory.generateReceipt(account, transactions);
            }

            if (choice == 7) {
                System.out.println("Please enter the amount to convert: ");
                BigDecimal amount = scan.nextBigDecimal();
                scan.nextLine();

                System.out.println("Enter the currency you are converting from (USD, EUR, JPY, GBP, AUD): ");
                String fromCurrency = scan.nextLine().toUpperCase();

                System.out.println("Enter the currency you are converting to (USD, EUR, JPY, GBP, AUD): ");
                String toCurrency = scan.nextLine().toUpperCase();

                try {
                    BigDecimal convertedAmount = currencyExchange.convert(amount, fromCurrency, toCurrency);
                    System.out.println("Converted amount: " + convertedAmount + " " + toCurrency);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }


            if (choice == 8) {

            }

            if (choice != 9) {
                System.out.println("\n     Bank Menu");
                System.out.println("======================");
            }
        }
        System.out.println("\nloop has exited");
        scan.close();
    }
}
