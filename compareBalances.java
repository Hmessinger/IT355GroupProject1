
/**
 * This class compares the user's savings and checkings balances. It then
 * returns a message based on the comparison. This class impelments the rule:
 * EXP03-J: Do not use the equality operators when comparing values of boxed
 * primitives.
 * 
 * This class also implements the following recommendations:
 * EXP51-J: Do not perform assignments in conditional expressions.
 * EXP52-J: Use braces for the body of an if, for, or while statement.
 */
public class compareBalances {

    /**
     * This method compares the savings and checkings balances of a user's account.
     * 
     * @param account - The user account.
     */
    public void compareBalances(BankAccount account) {
        Double savings = new Double(account.getSavingsBalance());
        Double checkings = new Double(account.getCheckingsBalance());

        // This if else-if else statement follows these recommendatins:
        // EXP51-J: Do not perform assignments in conditional expressions.
        // EXP52-J: Use braces for the body of an if, for, or while statement.
        if (savings.equals(checkings)) {
            System.out.println("Your savings and checkings balances are equal.");
        } else if (savings > checkings) {
            System.out.println(
                    "You have $" + (savings - checkings) + " more in your savings than your checkings account.");
        } else {
            System.out.println(
                    "You have $" + (checkings - savings) + " more in your checkings than your savings account.");
        }
    }
}