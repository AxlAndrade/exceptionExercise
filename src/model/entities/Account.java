package model.entities;

import model.exceptions.BusinessException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
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

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double value) {
		balance += value;
		System.out.printf("New balance: %.2f", balance);
	}
	
	public void withdraw(double value) {
		balance -= value;
		System.out.printf("New balance: %.2f", balance);
	}

	public void validateWithdraw(double value) {
		if (value > getWithdrawLimit()) {
			throw new BusinessException("A quantia excede o limite diário de saque.");
		}
		if (value > getBalance()) {
			throw new BusinessException("Saldo insuficiente para saque.");
		}
	}
	
}
