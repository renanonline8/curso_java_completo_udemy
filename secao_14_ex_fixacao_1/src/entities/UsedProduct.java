package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	private Date manufactureDate;

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String priceTag() {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		return this.getName() +
				" (used) $ " +
				String.format("%.2f", this.getPrice()) +
				" (Manufacture date: " +
				sdf1.format(manufactureDate) +
				")";
	}
}
