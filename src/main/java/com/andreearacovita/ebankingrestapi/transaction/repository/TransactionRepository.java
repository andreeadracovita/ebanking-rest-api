package com.andreearacovita.ebankingrestapi.transaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreearacovita.ebankingrestapi.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	List<Transaction> findAllByFromAccountNumber(String accountNumber);
	
	List<Transaction> findAllByToAccountNumber(String accountNumber);

}
