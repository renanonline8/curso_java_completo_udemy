package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			System.out.print("Enter salary: ");
			Double salary = sc.nextDouble();
			
			List<Employee> employeeList = new ArrayList<>();
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				employeeList.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			System.out.println("Email of people whose salary is more than 2000.00:");
			List<String> emailsPeopleSalaryMoreThan = employeeList.stream()
					.filter(p -> p.getSalary() > salary)
					.map(p -> p.getEmail()).sorted()
					.collect(Collectors.toList());
			emailsPeopleSalaryMoreThan.forEach(System.out::println);
			
			double sumSalaryWithLetterStartWith = employeeList.stream()
					.filter(p -> p.getName().charAt(0) == 'M')
					.map(p -> p.getSalary())
					.reduce(0.0, (x,y) -> x + y);
			System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sumSalaryWithLetterStartWith));
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
