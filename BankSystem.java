
// Main function file
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.spi.TransactionalWriter;

public class BankSystem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userName;
        String userPassword;
        int userCustomerID;
        int userAcctNum;
        double initialCheckingDeposit;
        double initialSavingsDeposit;

        System.out.println("Welcome to the Bank System.");

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
        while (true) {
            System.out.println("Please input the customer name: ");
            userName = scan.nextLine();
            if (userName != null && !userName.isEmpty()) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a name that is not empty.");
            }
        }

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

        CurrencyExchange currencyExchange = new CurrencyExchange();

        // Account Constructor
        BankAccount account = new BankAccount(userName, userCustomerID, userAcctNum, initialCheckingDeposit,
                initialSavingsDeposit, userPassword);

        System.out.print("\nAccount created successfully!\n");

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
            scan.nextLine();
            System.out.println("You selected: " + choice);

            if (choice == 1) {
                double temp;
                while (true) {
                    System.out.println("Please select the account you wish to deposit into (1 or 2):\n(1) Checking\n(2) Savings");
                    temp = scan.nextInt();
                    if (temp == 1) {
                        System.out.println("Your current balance: " + account.getCheckingsBalance());
                        System.out.println("How much do you wish to deposit?");
                        temp = scan.nextDouble();
                        account.setCheckingsBalance(account.getCheckingsBalance() + temp);
                        System.out.println("Your new balance: " + account.getCheckingsBalance());
                        break;
                    } else if (temp == 2) {
                        System.out.println("Your current balance: " + account.getSavingsBalance());
                        System.out.println("How much do you wish to deposit?");
                        temp = scan.nextDouble();
                        account.setSavingsBalance(account.getSavingsBalance() + temp);
                        System.out.println("Your new balance: " + account.getSavingsBalance());
                        break;
                    } else {
                        System.out.println("Please enter either 1 or 2");
                    }
                }

            }

            if (choice == 2) {
                System.out.println("Please select the account you wish to withdraw from (1 or 2):\n(1) Checking\n(2) Savings");
                double temp = scan.nextInt();
                while (true) {
                    if (temp == 1) {
                        System.out.println("Your current balance: " + account.getCheckingsBalance());
                        System.out.println("How much do you wish to withdraw?");
                        temp = scan.nextDouble();
                        if (account.getCheckingsBalance() - temp <= -1) {
                            System.out.println("You do not have enough funds in your account to complete your withdraw request");
                            break;
                        } else {
                            account.setCheckingsBalance(account.getCheckingsBalance() - temp);
                            System.out.println("Your new balance: " + account.getCheckingsBalance());
                            break;
                        }
                    } else if (temp == 2) {
                        System.out.println("Your current balance: " + account.getSavingsBalance());
                        System.out.println("How much do you wish to withdraw?");
                        temp = scan.nextDouble();
                        if (account.getSavingsBalance() - temp <= -1) {
                            System.out.println("You do not have enough funds in your account to complete your withdraw request.");
                            break;
                        } else {
                            account.setSavingsBalance(account.getSavingsBalance() - temp);
                            System.out.println("Your new balance: " + account.getSavingsBalance());
                            break;
                        }
                    } else {
                        System.out.println("Please enter either 1 or 2");
                    }
                }

            }

            if (choice == 3) {
                System.out.println("\nYour account info:");
                System.out.println(account);
            }

            if (choice == 4) {
                ManualPassword mp = new ManualPassword();
                String newPassword;
                while (true) {
                    System.out.println("\nPlease input your new password: ");
                    newPassword = scan.nextLine();
                    if (newPassword != null && !newPassword.isEmpty()) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a password that is not empty.");
                    }
                }
                mp.generateManualPassword(account, newPassword);
            }

            if (choice == 5) {
                System.out.println("\n");
                RandomPassword rp = new RandomPassword();
                rp.generateRandomPassword(account);
            }

            if (choice == 6) {
                if (choice == 6) {
                    System.out.println("Would you like to clear your old receipts? (Y/N)");
                    String temp = scan.next().toUpperCase();
                    if ("Y".equals(temp)) {
                        transactionHistory.cleanupOldReceipts();
                        System.out.println("Removed old receipts");
                    }
                
                    System.out.println("Would you like to generate a transaction history receipt? (Y/N)");
                    temp = scan.next().toUpperCase();
                    if ("Y".equals(temp)) {
                        transactionHistory.generateReceipt(account, transactions);
                        if (transactionHistory != null) {
                            System.out.println("Generated transaction receipt in " + userAcctNum + "-receipt.txt");
                        }
                    }
                    System.out.println("Returning to main menu");
                }

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
                // sub-loop for transfer funds
                int transferChoice = 0;

                while (true) {
                    System.out.println("\nTransfer Funds Menu:");
                    System.out.println("1: Transfer from Savings to Checking");
                    System.out.println("2: Transfer from Checking to Savings");
                    System.out.println("3: Show Transfer History");
                    System.out.println("4: Set Up Recurring Transfer");
                    System.out.println("5: Exit Transfer Menu");
                    System.out.print("Please input your choice <1-5>: ");
                    transferChoice = scan.nextInt();

                    switch (transferChoice) {
                        case 1:
                            System.out.print("Please enter the amount you would like to transfer: ");
                            int amount1 = scan.nextInt();
                            System.out.println("Transferred " + amount1 + " from Savings to Checking.");
                            break;
                        case 2:
                            System.out.print("Please enter the amount you would like to transfer: ");
                            int amount2 = scan.nextInt();
                            System.out.println("Transferred " + amount2 + " from Checking to Savings.");
                            break;
                        case 3:
                            System.out.println("Transfer History here.");
                            break;
                        case 4:
                            System.out.println("Please set up a recurring transfer.");
                            break;
                        case 5:
                            System.out.println("Exiting Transfer Funds Menu.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please select between 1 and 5.");
                            break;
                    }

                    // exit transfer menu if option 5 is chosen
                    if (transferChoice == 5) {
                        break;
                    }
                }
            }
            if (choice != 9) {
                System.out.println("\n     Bank Menu");
                System.out.println("======================");
            }
        }
        System.out.println("\nYou have exited the bank system.");
        scan.close();
    }
}
