package com.andreearacovita.ebankingrestapi.card;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Card {
		
	@Id
	private String cardNumber;
	
	private String cardName;
	
	private String nameOnCard;
	
	private String accountNumber;
	
	private CardType type;
	
	private LocalDate availabilityDate;
	
	private String pin;
	
	private String cvv;
	
	public Card() {}

	public Card(String cardNumber, String cardName, String nameOnCard, String accountNumber, CardType type,
			LocalDate availabilityDate, String pin, String cvv) {
		super();
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.nameOnCard = nameOnCard;
		this.accountNumber = accountNumber;
		this.type = type;
		this.availabilityDate = availabilityDate;
		this.pin = pin;
		this.cvv = cvv;
	}

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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
}
