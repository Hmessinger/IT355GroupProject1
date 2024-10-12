import java.math.BigDecimal;
import java.math.RoundingMode;

class CurrencyExchange {

  // DCL54-J. Use meaningful symbolic constants to represent literal values in program logic
  private static final BigDecimal MAX_LIMIT = new BigDecimal("1000000000000");
  private static final BigDecimal MIN_LIMIT = BigDecimal.ZERO;

  // DCL00-J: Prevent class initialization cycles
  private String[] currencyCode = {"USD", "EUR", "JPY", "GBP", "AUD"};
  private BigDecimal[] exchangeRates = {
    new BigDecimal("1.0"), 
    new BigDecimal("0.85"), 
    new BigDecimal("110.0"), 
    new BigDecimal("0.75"), 
    new BigDecimal("1.35")
  };


  // DCL01-J: Do not reuse public identifiers from the Java Standard Library
  public BigDecimal getExchangeRate(String code) {
    if (code == null || code.isEmpty()) {
      throw new IllegalArgumentException("Currency code must not be null or empty.");
    }
    // NUM09-J. Do not use floating-point variables as loop counters
    for (int i = 0; i < currencyCode.length; i++){
      if (currencyCode[i].equals(code)){
        return exchangeRates[i];
      }
    }
    throw new IllegalArgumentException("Currency code not found.");
  }



  public BigDecimal convert(BigDecimal amount, String fromCurrency, String toCurrency) {
    
    if (amount.compareTo(MIN_LIMIT) < 0){
      // ERR51-J. Prefer user-defined exceptions over more general exception types
      throw new IllegalArgumentException("Amount must be greater than 0.");
    }

    // DCL52-J: Do not declare more than one variable per declaration
    BigDecimal fromRate = getExchangeRate(fromCurrency);
    BigDecimal toRate = getExchangeRate(toCurrency);

    BigDecimal result;

    try {
      // EXP53-J: Use parentheses for precedence of operation
      // ERR00-J: Handle checked exceptions properly
      // NUM04-J: Do not use floating-point numbers if precise computation is required
      result = amount.divide(fromRate, 10, RoundingMode.HALF_UP).multiply(toRate);
    } catch (ArithmeticException e) {
      // ERR01-J: Do not allow exceptions to expose sensitive information
      throw new ArithmeticException("An error occurred during currency conversion.");
    }

    // NUM00-J: Detect or prevent integer overflow
    if (result.compareTo(MAX_LIMIT) > 0) {
      throw new ArithmeticException("Overflow: Result exceeds maximum limit.");
    }

    return result;
  }
}
