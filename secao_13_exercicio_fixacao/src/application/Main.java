package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdfOnlyDate = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfDateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date(DD/MM/YYYY): ");
		Date clientBirthDate = sdfOnlyDate.parse(sc.nextLine());
		Client client = new Client(clientName, clientEmail, clientBirthDate, sdfOnlyDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderStatus = sc.nextLine();
		Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus));
		
		System.out.print("How many items to this order? ");
		int qtdItems = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= qtdItems; i++) {
			System.out.printf("Enter #%d item data:", i);
			System.out.println();
			System.out.print("Product name: ");
			String productName = sc.next();
			sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			Product product = new Product(productName, productPrice);
			System.out.print("Quantity: ");
			Integer orderItemQuantity = sc.nextInt();
			System.out.println();
			OrderItem orderItem = new OrderItem(orderItemQuantity, productPrice, product);
			order.addItem(orderItem);
		}
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.printf("Order moment: %s \n", sdfDateTime.format(order.getMoment()));
		System.out.printf("Order status: %s \n", order.getStatus());
		System.out.println(client);
		System.out.println("Orders items:");
		for (OrderItem orderItemElem : order.getItems()) {
			System.out.println(orderItemElem);
		}
		System.out.printf("Total price: $%.2f", order.total());
		sc.close();
	}

}
