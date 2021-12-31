package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> productsList = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char productType = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Price: ");
			Double productPrice = sc.nextDouble();
			
			Double productCustomsFee = null;
			if (productType == 'i') {
				System.out.print("Customs fee: ");
				productCustomsFee = sc.nextDouble();
			}
			
			Date productManufactureDate = null;
			if (productType == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				productManufactureDate = sdf.parse(sc.next());
			}
			
			switch (productType) {
			case 'c':
				Product product = new Product(productName, productPrice);
				productsList.add(product);
				break;
			case 'i':
				ImportedProduct importedProduct = new ImportedProduct(productName, productPrice, productCustomsFee);
				productsList.add(importedProduct);
				break;
			case 'u':
				UsedProduct usedProduct = new UsedProduct(productName, productPrice, productManufactureDate);
				productsList.add(usedProduct);
				break;
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product product : productsList) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
	}

}
