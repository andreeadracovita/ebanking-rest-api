package com.andreearacovita.ebankingrestapi.jpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andreearacovita.ebankingrestapi.appaccount.AppAccount;
import com.andreearacovita.ebankingrestapi.appaccount.repository.AppAccountRepository;
import com.andreearacovita.ebankingrestapi.bankaccount.BankAccount;
import com.andreearacovita.ebankingrestapi.bankaccount.BankAccountCurrency;
import com.andreearacovita.ebankingrestapi.bankaccount.BankAccountType;
import com.andreearacovita.ebankingrestapi.bankaccount.repository.BankAccountRepository;
import com.andreearacovita.ebankingrestapi.card.Card;
import com.andreearacovita.ebankingrestapi.card.repository.CardRepository;
import com.andreearacovita.ebankingrestapi.customer.Customer;
import com.andreearacovita.ebankingrestapi.customer.repository.CustomerRepository;
import com.andreearacovita.ebankingrestapi.transaction.Transaction;
import com.andreearacovita.ebankingrestapi.transaction.repository.TransactionRepository;

@RestController
public class EBankingJpaResource {
	
	private BankAccountRepository bankAccountRepository;
	
	private CardRepository cardRepository;
	
	private CustomerRepository customerRepository;
	
	private AppAccountRepository appAccountRepository;
	
	private TransactionRepository transactionRepository;
	
	public EBankingJpaResource(BankAccountRepository bankAccountRepository,
							   CardRepository cardRepository,
							   CustomerRepository customerRepository,
							   AppAccountRepository appAccountRepository,
							   TransactionRepository transactionRepository) {
		this.bankAccountRepository = bankAccountRepository;
		this.cardRepository = cardRepository;
		this.customerRepository = customerRepository;
		this.appAccountRepository = appAccountRepository;
		this.transactionRepository = transactionRepository;
	}
	
	@GetMapping("/{username}/customername")
	public String retrieveCustomerNameForUsername(@PathVariable String username) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		
		Customer customer = customerRepository.findById(appAccount.getCustomerId()).get();
		
		return customer.getFirstName() + " " + customer.getLastName();
	}
	
	@GetMapping("/{username}/accounts/checking")
	public List<BankAccount> retrieveCheckingAccountsForUsername(@PathVariable String username) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		
		List<BankAccount> bankAccounts = bankAccountRepository.findByCustomerId(appAccount.getCustomerId());
		
		return bankAccounts
					.stream()
					.filter(bankAccount -> bankAccount.getType() == BankAccountType.CHECKING)
					.toList();
	}
	
	@GetMapping("/{username}/accounts/credit")
	public List<BankAccount> retrieveCreditAccountsForUsername(@PathVariable String username) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		
		List<BankAccount> bankAccounts = bankAccountRepository.findByCustomerId(appAccount.getCustomerId());
		
		return bankAccounts
					.stream()
					.filter(bankAccount -> bankAccount.getType() == BankAccountType.CREDIT)
					.toList();
	}
	
	@GetMapping("/{username}/accounts/savings")
	public List<BankAccount> retrieveSavingsAccountsForUsername(@PathVariable String username) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		
		List<BankAccount> bankAccounts = bankAccountRepository.findByCustomerId(appAccount.getCustomerId());
		
		return bankAccounts
					.stream()
					.filter(bankAccount -> bankAccount.getType() == BankAccountType.SAVINGS)
					.toList();
	}
	
	@GetMapping("/{username}/accounts/local")
	public List<BankAccount> retrieveAllLocalBankAccountsForUsername(@PathVariable String username) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		
		List<BankAccount> bankAccounts = bankAccountRepository.findByCustomerId(appAccount.getCustomerId());
		
		return bankAccounts
				.stream()
				.filter(bankAccount -> bankAccount.getCurrency() == BankAccountCurrency.CHF)
				.toList();
	}
	
	@GetMapping("/{username}/accounts/foreign")
	public List<BankAccount> retrieveAllForeignBankAccountsForUsername(@PathVariable String username) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		
		List<BankAccount> bankAccounts = bankAccountRepository.findByCustomerId(appAccount.getCustomerId());
		
		return bankAccounts
				.stream()
				.filter(bankAccount -> bankAccount.getCurrency() != BankAccountCurrency.CHF)
				.toList();
	}
	
	@GetMapping("/{username}/accounts")
	public List<BankAccount> retrieveAllBankAccountsForUsername(@PathVariable String username) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		
		return bankAccountRepository.findByCustomerId(appAccount.getCustomerId());
	}
	
	@GetMapping("/{username}/cards")
	public List<Card> retrieveAllCardsForUsername(@PathVariable String username) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		
		List<BankAccount> bankAccounts = bankAccountRepository.findByCustomerId(appAccount.getCustomerId());
		
		List<Card> cards = new ArrayList<>();
		for (var bankAccount : bankAccounts) {
			List<Card> currentCards = cardRepository.findByAccountNumber(bankAccount.getAccountNumber());
			cards.addAll(currentCards);
		}
		
		return cards;
	}
	
	@GetMapping("/{username}/{bankAccountNumber}/transactions")
	public List<Transaction> retrieveAllTransactionsForBankAccountNumber(@PathVariable String username, @PathVariable String bankAccountNumber) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		
		Optional<BankAccount> bankAccount = bankAccountRepository.findByAccountNumber(bankAccountNumber);
		
		if (!bankAccount.isPresent() || bankAccount.isPresent() && bankAccount.get().getCustomerId() != appAccount.getCustomerId()) {
			return new ArrayList<>();
		}
		
		List<Transaction> transactions = transactionRepository.findAllByFromAccountNumber(bankAccountNumber);
		
		transactions.addAll(transactionRepository.findAllByToAccountNumber(bankAccountNumber));
		
		Comparator<Transaction> comparatorDesc = (trans1, trans2) -> trans1.getIssueDate()
                .compareTo(trans2.getIssueDate());
		
		Collections.sort(transactions, comparatorDesc);
		
		
		return transactions;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/{username}/transaction")
	public Transaction createTransaction(@PathVariable String username, @RequestBody Transaction transaction) {
		// Validate sufficient funds
		
		transaction.setId(null);
		transaction.setIssueDate(LocalDate.now());
		return transactionRepository.save(transaction);
	}
	
//	@GetMapping("/users/{username}/todos/{id}")
//	public BankAccount retrieveTodo(@PathVariable String username, @PathVariable int id) {
//		return bankAccountRepository.findById(id).get();
//	}
//	
//	@DeleteMapping("/users/{username}/todos/{id}")
//	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
//		bankAccountRepository.deleteById(id);
//		return ResponseEntity.noContent().build();
//	}
//	
//	@PutMapping("/users/{username}/todos/{id}")
//	public BankAccount updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody BankAccount bankAccount) {
//		bankAccountRepository.save(bankAccount);
//		return bankAccount;
//	}
//	
//	@PostMapping("/users/{username}/todos")
//	public BankAccount createTodo(@PathVariable String username, @RequestBody BankAccount bankAccount) {
//		bankAccount.setUsername(username);
//		bankAccount.setId(null);
//		return bankAccountRepository.save(bankAccount);
//	}
}
