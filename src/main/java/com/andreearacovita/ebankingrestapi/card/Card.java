package com.andreearacovita.ebankingrestapi.card;

import java.time.LocalDate;

import com.andreearacovita.ebankingrestapi.bankaccount.BankAccount;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Card {
		
	@Id
	@Column(nullable = false, unique = true)
	private String cardNumber;
	
	@Column(nullable = false)
	private String cardName;
	
	@Column(nullable = false)
	private String nameOnCard;
	
	@Column(nullable = false)
	private CardType type;
	
	@Column(nullable = false)
	private LocalDate availabilityDate;
	
	@Column(nullable = false)
	private String pin;
	
	@Column(nullable = false)
	private String cvv;
	
	@Column(nullable = false)
	private CardStatus status;
	
	@ManyToOne
	@JoinColumn(name="account_number", nullable=false)
	private BankAccount bankAccount;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public CardType getType() {
		return type;
	}

	public void setType(CardType type) {
		this.type = type;
	}

	public LocalDate getAvailabilityDate() {
		return availabilityDate;
	}

	public void setAvailabilityDate(LocalDate availabilityDate) {
		this.availabilityDate = availabilityDate;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public CardStatus getStatus() {
		return status;
	}

	public void setStatus(CardStatus status) {
		this.status = status;
	}
}
