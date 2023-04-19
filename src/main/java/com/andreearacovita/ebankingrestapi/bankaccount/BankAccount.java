package com.andreearacovita.ebankingrestapi.bankaccount;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankAccount {

	@Id
	private String accountNumber;
	
	private String accountName;
	
	private Integer customerId;
	
	private BankAccountType type;
	
	private Double balance;

	private BankAccountCurrency currency;
	
	public BankAccount() {}

	public BankAccount(String accountNumber, String accountName, Integer customerId, BankAccountType type, Double balance,
			BankAccountCurrency currency) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.customerId = customerId;
		this.type = type;
		this.balance = balance;
		this.currency = currency;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public BankAccountType getType() {
		return type;
	}

	public void setType(BankAccountType type) {
		this.type = type;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public BankAccountCurrency getCurrency() {
		return currency;
	}

	public void setCurrency(BankAccountCurrency currency) {
		this.currency = currency;
	}
	
	public boolean deposit(Double amount) {
		if (amount >= 0) {
			this.balance += amount;
			return true;
		}
		return false;
	}
	
	public boolean withdraw(Double amount) {
		if (amount >=0 && balance >= amount) {
			this.balance -= amount;
			return true;
		}
		return false;
	}
}
