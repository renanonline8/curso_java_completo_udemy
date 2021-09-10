package entitie;

public class CurrencyConverter {
	public static double dollarToReal(double quoteUSD, double valueToConversion) {
		return valueToConversion * quoteUSD * 1.06;
	}
}
