package com.andreearacovita.ebankingrestapi.transaction;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private Integer transactionId;
	
	private TransactionType type;
	
	private Integer fromAccountId;
	
	private Integer toAccountId;
	
	private LocalDate issueDate;
	
	private Double amount;

	public Transaction(Integer transactionId, TransactionType type, Integer fromAccountId, Integer toAccountId,
			LocalDate issueDate, Double amount) {
		super();
		this.transactionId = transactionId;
		this.type = type;
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.issueDate = issueDate;
		this.amount = amount;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public Integer getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(Integer fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public Integer getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(Integer toAccountId) {
		this.toAccountId = toAccountId;
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
}

enum TransactionType {
	
}