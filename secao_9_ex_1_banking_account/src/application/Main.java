package application;

import java.util.Locale;
import java.util.Scanner;

import entitie.Account;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account firstExampleAccount;
		
		//First Example
		System.out.print("Enter account number: ");
		int accountNumber = sc.nextInt();
		
		System.out.print("Enter account holder: ");
		sc.nextLine();
		String ownerName = sc.nextLine();
		
		System.out.print("Is there an initial deposit (y/n)? ");
		char hasInitialBalance = sc.next().charAt(0);
		if (hasInitialBalance == 'y') {
			System.out.print("Enter initial deposit value: ");
			float balance = sc.nextFloat();
			firstExampleAccount = new Account(accountNumber, ownerName, balance);
		} else {
			firstExampleAccount = new Account(accountNumber, ownerName);
		}
		
		System.out.println();
		System.out.println("Account data:");
		System.out.println(firstExampleAccount);
		
		System.out.print("Enter a deposit value: ");
		firstExampleAccount.depositValue(sc.nextFloat());
		System.out.println("Updated account data: ");
		System.out.println(firstExampleAccount);
		
		System.out.print("Enter a withdraw value: ");
		firstExampleAccount.withdrawValue(sc.nextFloat());
		System.out.println("Updated account data: ");
		System.out.println(firstExampleAccount);
		
		sc.close();
	}

}
