package com.andreearacovita.ebankingrestapi.bankaccount;

import java.time.LocalDateTime;
import java.util.Set;

import com.andreearacovita.ebankingrestapi.card.Card;
import com.andreearacovita.ebankingrestapi.customer.Customer;
import com.andreearacovita.ebankingrestapi.transaction.Transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class BankAccount {

	@Id
	@Column(nullable = false)
	private String accountNumber;
	
	@Column(nullable = false)
	private String accountName;
	
	@Column(nullable = false)
	private BankAccountType type;
	
	@Column(nullable = false)
	private Double balance;

	@Column(nullable = false)
	private BankAccountCurrency currency;
	
	@Column(nullable = false)
	private LocalDateTime issueDate;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;
	
	@OneToMany(mappedBy = "bankAccount")
	private Set<Card> cards;

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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	
	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
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
