package com.andreearacovita.ebankingrestapi.bankaccount;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankAccount {
	
	enum BankAccountType {
		checking,
		credit,
		savings,
	}
	
	enum BankAccountCurrency {
		CHF,
		EUR,
		USD
	}

	@Id
	private String accountNumber;
	
	private Integer customerID;
	
	private BankAccountType type;
	
	private Double balance;

	private BankAccountCurrency currency;

	public BankAccount(String accountNumber, Integer customerID, BankAccountType type, Double balance,
			BankAccountCurrency currency) {
		super();
		this.accountNumber = accountNumber;
		this.customerID = customerID;
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

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
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

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", customerID=" + customerID + ", type=" + type
				+ ", balance=" + balance + ", currency=" + currency + "]";
	}
}
