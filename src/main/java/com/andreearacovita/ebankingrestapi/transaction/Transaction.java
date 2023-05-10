package com.andreearacovita.ebankingrestapi.transaction;

import java.time.LocalDateTime;

import com.andreearacovita.ebankingrestapi.bankaccount.BankAccount;
import com.andreearacovita.ebankingrestapi.bankaccount.BankAccountCurrency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String fromAccountNumber;
	
	@Column(nullable = false)
	private String toAccountNumber;
	
	@Column(nullable = false)
	private LocalDateTime issueDate;
	
	@Column(nullable = false)
	private Double amount;
	
	@Column(nullable = false)
	private BankAccountCurrency currency;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Double exchangeRate;

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

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
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