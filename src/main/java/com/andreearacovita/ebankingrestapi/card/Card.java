package com.andreearacovita.ebankingrestapi.card;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Card {
	
	enum CardType {
		credit,
		debit
	};
	
	enum Provider {
		mastercard,
		visa
	};
	
	@Id
	private String cardNumber;
	
	private String nameOnCard;
	
	private String accountNumber;
	
	private CardType type;
	
	private Provider provider;
	
	private LocalDate availabilityDate;
	
	private Integer pin;
	
	private Integer cvv;
	
	private Integer limitDailyPayments;

	public Card(String cardNumber, String nameOnCard, String accountNumber, CardType type, Provider provider,
			LocalDate availabilityDate, Integer pin, Integer cvv, Integer limitDailyPayments) {
		super();
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.accountNumber = accountNumber;
		this.type = type;
		this.provider = provider;
		this.availabilityDate = availabilityDate;
		this.pin = pin;
		this.cvv = cvv;
		this.limitDailyPayments = limitDailyPayments;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
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

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public LocalDate getAvailabilityDate() {
		return availabilityDate;
	}

	public void setAvailabilityDate(LocalDate availabilityDate) {
		this.availabilityDate = availabilityDate;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Integer getLimitDailyPayments() {
		return limitDailyPayments;
	}

	public void setLimitDailyPayments(Integer limitDailyPayments) {
		this.limitDailyPayments = limitDailyPayments;
	}
}
