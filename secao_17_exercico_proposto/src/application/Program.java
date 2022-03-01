package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o caminho do arquivo:");
		String filePath = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = br.readLine();
			List<Product> products = new ArrayList<>();
			while(line != null) {
				String lineRead[] = line.split(",");
				Product product = new Product(lineRead[0], Double.parseDouble(lineRead[1]), Integer.parseInt(lineRead[2]));
				products.add(product);
				line = br.readLine();
			}
			
			File file = new File(filePath);
			boolean successCreatedFolder = new File(file.getParent() + "\\out").mkdir();
			
			if (successCreatedFolder) {
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getParent() + "\\out\\summary.csv"))) {
					for (Product product : products) {
						bw.write(product.getName() + "," + product.totalItemPrice());
						bw.newLine();
					}
				} catch (IOException e) {
					System.out.println("Error: " + e.getMessage());
				}
			} else {
				System.out.println("Error to create directory");
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
