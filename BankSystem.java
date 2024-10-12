// Main function file
import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {   
        Scanner scan = new Scanner(System.in);
        System.out.println("Create Account:");
        //Asks for users name
        System.out.println("Please input the customer name: ");
        String userName = scan.nextLine();

        //Asks for the users customer id
        System.out.println("\nPlease input the customer ID: ");
        int userCustomerID = scan.nextInt();

        //Asks for the account number
        System.out.println("\nPlease input the account number: ");
        int userAcctNum = scan.nextInt();

        System.out.println("\nPlease input the account password: ");
        String userPassword = scan.next();

        System.out.println("\nPlease input initial deposit for checking account: ");
        double initialCheckingDeposit = scan.nextDouble();

        System.out.println("\nPlease input initial deposit for savings account: ");
        double initialSavingsDeposit = scan.nextDouble();

        System.out.println("\nAccount created successfully!");

        System.out.println("\n     Bank Menu");
        System.out.println("======================");


        //Loop is working correctly
        int choice = 0;
        while(choice!=8){
            System.out.println("1:Deposit");
            System.out.println("2:Withdraw");
            System.out.println("3:Display Account");
            System.out.println("4:Change Password");
            System.out.println("5:Transaction History");
            System.out.println("6:Currency Conversion");
            System.out.println("7:Transfer Funds");
            System.out.println("8: Exit");
            

            System.out.println("Please input your choice <1-8>");
            choice = scan.nextInt();
            System.out.println("You selected: " + choice);

           if(choice != 8){
            System.out.println("\n     Bank Menu");
            System.out.println("======================");
           }
        }
        System.out.println("\nloop has exited");
        scan.close();
    }
}    
    
