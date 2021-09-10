package application;

import java.util.Locale;
import java.util.Scanner;

import entitie.CurrencyConverter;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("What is the dollar price? ");
		double quoteDollar = sc.nextDouble();
		
		System.out.print("How many dollar will be bought? ");
		double valueToConversion = sc.nextDouble();
		
		System.out.printf("Amount to be paid in reais = %.2f", CurrencyConverter.dollarToReal(quoteDollar, valueToConversion));
		
		sc.close();
	}

}
