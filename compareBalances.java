
/**
 * This class compares the user's savings and checkings balances. It then
 * returns a message based on the comparison. This class implements the rule:
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
     * It uses the .equals method to compare the boxed primitives rather than using
     * the equality operators. This follows the rule: EXP03-J: Do not use the
     * equality operators when comparing values of boxed
     * primitives.
     * 
     * Instead of using the deprecated Double constructor class, we used the method
     * Double.valueOf method to turn the double values into boxed Doubles.
     * This implements the rule: MET02-J. Do not use deprecated or obsolete classes
     * or methods.
     * 
     * @param account - The user account.
     */
    public void compareBalances(BankAccount account) {
        Double savings = Double.valueOf(account.getSavingsBalance());
        Double checkings = Double.valueOf(account.getCheckingsBalance());

        // This if else-if else statement follows these recommendations:
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