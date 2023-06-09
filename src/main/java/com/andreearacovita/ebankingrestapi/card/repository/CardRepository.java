package com.andreearacovita.ebankingrestapi.card.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreearacovita.ebankingrestapi.bankaccount.BankAccount;
import com.andreearacovita.ebankingrestapi.card.Card;

public interface CardRepository  extends JpaRepository<Card, Integer> {
	
	List<Card> findByBankAccount(BankAccount bankAccount);

	Card findByCardNumber(String generatedCardNumber);

	void deleteByCardNumber(String cardNumber);
}
