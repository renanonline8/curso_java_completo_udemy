package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file full path: ");
		String filepath = sc.next();
		Map<String, Integer> voters = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			String line = br.readLine();
			while (line != null) {				
				String vote[] = line.split(",");
				Integer qtdValue;
				if (voters.containsKey(vote[0])) {
					qtdValue = voters.get(vote[0]) + Integer.parseInt(vote[1]);
				} else {
					qtdValue = Integer.parseInt(vote[1]);
				}
				voters.put(vote[0], qtdValue);
				line = br.readLine();
			}
			for (String k : voters.keySet()) {
				System.out.println(k + ": " + voters.get(k));
			}
		} catch (IOException e) {
			System.out.print("Error: " + e.getMessage());
		}
		sc.close();
	}

}
