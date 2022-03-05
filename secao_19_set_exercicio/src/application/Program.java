package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Set<Integer> students = new HashSet<>();
		
		@SuppressWarnings("serial")
		ArrayList<String> courses = new ArrayList<String>() {{
			add("A");
			add("B");
			add("C");
		}};
		
		for (String course : courses) {
			System.out.print("How many students for course " + course);
			int studentsQuantity = sc.nextInt();
			for (int i = 0; i < studentsQuantity; i++) {
				students.add(sc.nextInt());
			}
		}
		
		System.out.println("Total students: " + students.size());
		
		sc.close();
	}

}
