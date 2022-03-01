package entities;

public class Product {
	String name;
	double unitPrice;
	int quantity;
	
	public Product(String name, double unitPrice, int quantity) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity; 
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double totalItemPrice() {
		return unitPrice * quantity;
	}
}
