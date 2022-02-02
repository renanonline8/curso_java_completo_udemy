package model.entities;

import model.exceptions.DomainException;

public class Account {
	@SuppressWarnings("unused")
	private Integer number;
	@SuppressWarnings("unused")
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account(Integer number, String holder, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.withdrawLimit = withdrawLimit;
		this.balance = 0.0;
	}
	
	public void deposit(Double amount) {
		this.balance += amount;
	}
	
	public void withdraw(Double amount) throws DomainException {
		if (amount > this.withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		
		if (amount > this.balance) {
			throw new DomainException("Not enough balance");
		}
		
		this.balance -= amount;
	}
	
	public Double getBalance() {
		return this.balance;
	}
}
