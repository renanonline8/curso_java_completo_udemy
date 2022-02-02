package aplication;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer accountNumber = sc.nextInt();
			System.out.print("Holder: ");
			String accountHolder = sc.next();
			sc.nextLine();
			System.out.print("Initial balance: ");
			Double accountInitialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double accountWithDrawLimit = sc.nextDouble();
			
			Account account = new Account(accountNumber, accountHolder, accountWithDrawLimit);
			account.deposit(accountInitialBalance);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			account.withdraw(sc.nextDouble());
			System.out.println("New balance: " + account.getBalance());
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}

}
