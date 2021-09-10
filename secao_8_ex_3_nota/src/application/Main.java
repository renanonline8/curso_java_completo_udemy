package application;

import java.util.Locale;
import java.util.Scanner;

import entitie.Student;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Student student = new Student();
		
		student.name = sc.nextLine();
		student.addFinalGrade(sc.nextDouble());
		student.addFinalGrade(sc.nextDouble());
		student.addFinalGrade(sc.nextDouble());
		
		System.out.printf("FINAL GRADE = %.2f%n", student.finalGrade);
		System.out.println(student.checkPass());
		if(student.checkPass() != "PASS") {
			System.out.printf("MISSING %.2f POINTS", student.missingPoint());
		}
		sc.close();
	}

}
