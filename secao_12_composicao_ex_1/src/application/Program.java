package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Department;
import entities.Dependencie;
import entities.HourContract;
import entities.Worker;
import entities.enums.Genre;
import entities.enums.Type;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		System.out.println();
		System.out.print("How many dependencies to this worker? ");
		int quantitieDependencies = sc.nextInt();
		for (int i=0; i < quantitieDependencies; i++) {
			System.out.println("Enter dependencie #" + (i + 1) + " data:");
			System.out.print("Name: ");
			String dependencieName = sc.next();
			sc.nextLine();
			System.out.print("Genre (M/F): ");
			String dependencieGenre = sc.next();
			System.out.print("Type (CONJUNGE/DESCENDENTE): ");
			String dependencieType = sc.next();
			System.out.print("Birth Date: ");
			Date dependencieBirthDate = sdf.parse(sc.next());
			Dependencie dependencie = new Dependencie(
					dependencieName,
					Genre.valueOf(dependencieGenre), 
					Type.valueOf(dependencieType),
					dependencieBirthDate
					);
			worker.addDependencie(dependencie);
		}
		
		System.out.println();
		System.out.println(worker.getName() + "' daughters");
		List<Dependencie> daughters = worker.getDependencies().stream().filter(dependencie -> dependencie.getGenre() == Genre.F &&
				dependencie.getType() == Type.DESCENDENTE).collect(Collectors.toList());
		for (Dependencie daughter : daughters) {
			System.out.println(daughter);
		}
		
		sc.close();
	}
}
