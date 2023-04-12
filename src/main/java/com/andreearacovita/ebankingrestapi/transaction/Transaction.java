package com.andreearacovita.ebankingrestapi.transaction;

import java.time.LocalDate;

import com.andreearacovita.ebankingrestapi.bankaccount.BankAccountCurrency;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String fromAccountNumber;
	
	private String toAccountNumber;
	
	private LocalDate issueDate;
	
	private Double amount;
	
	private BankAccountCurrency currency;
	
	private String description;
	
	private Double exchangeRate;
	
	public Transaction() { }

	public Transaction(Integer id, String fromAccountNumber, String toAccountNumber,
			LocalDate issueDate, Double amount, BankAccountCurrency currency, String description, Double exchangeRate) {
		super();
		this.id = id;
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.issueDate = issueDate;
		this.amount = amount;
		this.currency = currency;
		this.description = description;
		this.exchangeRate = exchangeRate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public BankAccountCurrency getCurrency() {
		return currency;
	}

	public void setCurrency(BankAccountCurrency currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
}