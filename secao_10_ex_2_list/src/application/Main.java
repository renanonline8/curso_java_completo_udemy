package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitie.Employee;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int numberEmployeesWillBeRegistered = sc.nextInt();
		System.out.println();
		
		List<Employee> employeesRegistered = new ArrayList<>();
		
		for(int i = 0; i < numberEmployeesWillBeRegistered; i++) {
			System.out.printf("Employee #%d:%n", i + 1);
			
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			System.out.println();
			employeesRegistered.add(new Employee(id, name, salary));
		}
		
		System.out.print("Enter the employee id that will have salary increase : ");
		int employeeIdToIncreaseSalary = sc.nextInt();
		
		Employee employeeToIncreaseSalary = employeesRegistered.stream().filter(employee -> employee.getId() == employeeIdToIncreaseSalary).findFirst().orElse(null);
		if (employeeToIncreaseSalary == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			employeeToIncreaseSalary.increaseSalary(sc.nextDouble());
		}
		
		System.out.println();
		System.out.println("List of employees:");
		for (Employee employeeToShow : employeesRegistered) {
			System.out.println(employeeToShow);
		}
		
		sc.close();
	}
}
