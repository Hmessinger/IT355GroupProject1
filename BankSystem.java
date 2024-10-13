// Main function file

import java.math.BigDecimal;

public class BankSystem {
    public static void main(String[] args) {

        CurrencyExchange exchange = new CurrencyExchange();
        BigDecimal amount = new BigDecimal("1000.0"); // Example large amount

        // Convert $1,000 USD to EUR
        BigDecimal result = exchange.convert(amount, "USD", "EUR");
        System.out.println("1,000 USD to EUR: " + result);
    }
}