package entitie;

public class Account {
	private int accountNumber;
	private String ownerName;
	private float balance;
	
	public Account(int accountNumber, String ownerName, float balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public Account(int accountNumber, String ownerName) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public void depositValue(float value) {
		balance += value;
	}
	
	public void withdrawValue(float value) {
		float withdrawTax = 5;
		balance -= value + withdrawTax;
	}

	@Override
	public String toString() {
		return "Account "
				+ accountNumber
				+ ", Holder: "
				+ ownerName
				+ ", Balance: $ "
				+ balance;
	}
}
