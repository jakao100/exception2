package entities;

import exceptions.BusinessException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double witgdrawLimit;
	
	public Account() {
		
	}

	public Account(Integer number, String holder, Double balance, Double witgdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.witgdrawLimit = witgdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWitgdrawLimit() {
		return witgdrawLimit;
	}

	public void setWitgdrawLimit(Double witgdrawLimit) {
		this.witgdrawLimit = witgdrawLimit;
	}
	public void deposit(Double amount) {
		balance += amount;
	}
	public void withdraw(Double amount) {
		validateWithdraw(amount);
		balance -= amount;
	}
	private void validateWithdraw(double amount) {
		if (amount > getWitgdrawLimit()) {
			throw new BusinessException ("Withdraw error: The amount exceeds withdraw limit");
		} 
		if (amount > getBalance()) {
			throw new BusinessException ("Withdraw error: Not enough balance");
		}
	}
}
