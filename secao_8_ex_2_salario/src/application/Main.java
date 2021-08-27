package application;

import java.util.Locale;
import java.util.Scanner;

import entitie.Employee;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Employee employee = new Employee();
		
		System.out.print("Name: ");
		employee.name = sc.nextLine();
		
		System.out.print("Gross salary: ");
		employee.grossSalary = sc.nextFloat();
		
		System.out.print("Tax: ");
		employee.tax = sc.nextFloat();
		
		System.out.println();
		System.out.printf("Employee: %s%n%n", employee);
		
		System.out.print("Which percentage to increase salary? ");
		employee.increaseSalary(sc.nextDouble());
		System.out.println();
		
		System.out.printf("Updated data: %s", employee);
		
		
	}

}
