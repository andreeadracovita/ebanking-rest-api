package com.andreearacovita.ebankingrestapi.bankaccount.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreearacovita.ebankingrestapi.bankaccount.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

	List<BankAccount> findByCustomerId(Long customerId);
	
	BankAccount findByAccountNumber(String accountNumber);

	void deleteByAccountNumber(String accountNumber);
}
