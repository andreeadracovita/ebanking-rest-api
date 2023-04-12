package com.andreearacovita.ebankingrestapi.card.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreearacovita.ebankingrestapi.card.Card;
import com.andreearacovita.ebankingrestapi.customer.Customer;

public interface CardRepository  extends JpaRepository<Card, Integer> {
	
	List<Card> findByAccountNumber(String accountNumber);

	Card findByCardNumber(String generatedCardNumber);

	void deleteByCardNumber(String cardNumber);
}
