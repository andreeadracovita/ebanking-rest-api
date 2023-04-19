package com.andreearacovita.ebankingrestapi.jpa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.andreearacovita.ebankingrestapi.appaccount.AppAccount;
import com.andreearacovita.ebankingrestapi.appaccount.repository.AppAccountRepository;
import com.andreearacovita.ebankingrestapi.bankaccount.BankAccount;
import com.andreearacovita.ebankingrestapi.bankaccount.BankAccountCurrency;
import com.andreearacovita.ebankingrestapi.bankaccount.BankAccountType;
import com.andreearacovita.ebankingrestapi.bankaccount.repository.BankAccountRepository;
import com.andreearacovita.ebankingrestapi.card.Card;
import com.andreearacovita.ebankingrestapi.card.CardStatus;
import com.andreearacovita.ebankingrestapi.card.CardType;
import com.andreearacovita.ebankingrestapi.card.repository.CardRepository;
import com.andreearacovita.ebankingrestapi.customer.Customer;
import com.andreearacovita.ebankingrestapi.customer.repository.CustomerRepository;
import com.andreearacovita.ebankingrestapi.transaction.Transaction;
import com.andreearacovita.ebankingrestapi.transaction.repository.TransactionRepository;
import com.andreearacovita.ebankingrestapi.utils.Generator;

import jakarta.transaction.Transactional;

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
	
	@GetMapping("/{username}/customer/{id}")
	public String retrieveCustomerNameForId(@PathVariable String username, @PathVariable int id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			return customer.get().getFirstName() + " " + customer.get().getLastName();
		}
		return "";
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
	
	@GetMapping("/{username}/accounts/checking/local")
	public List<BankAccount> retrieveAllLocalCheckingBankAccountsForUsername(@PathVariable String username) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		
		List<BankAccount> bankAccounts = bankAccountRepository.findByCustomerId(appAccount.getCustomerId());
		
		return bankAccounts
				.stream()
				.filter(bankAccount -> bankAccount.getCurrency() == BankAccountCurrency.CHF && bankAccount.getType() == BankAccountType.CHECKING)
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
	
	@GetMapping("/{username}/accounts/{id}")
	public BankAccount retrieveBankAccountForAccountNumber(@PathVariable String username, @PathVariable String id) {
		AppAccount account = appAccountRepository.findByUsername(username);
		BankAccount bankAccount = bankAccountRepository.findByAccountNumber(id);
		
		if (account.getCustomerId() == bankAccount.getCustomerId()) {
			return bankAccount;
		}
		
		return null;
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
	
	@GetMapping("/{username}/cards/{id}/availabilityDate")
	public String retrieveAvailabilityDateForCardNumber(@PathVariable String username, @PathVariable String id) {
		// check user.customerId == account.customerId (for card.accountNumber)
		
		Card card = cardRepository.findByCardNumber(id);
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/yy");
		return card.getAvailabilityDate().format(dateTimeFormatter);
	}
	
	@GetMapping("/{username}/{bankAccountNumber}/transactions")
	public List<Transaction> retrieveAllTransactionsForBankAccountNumber(@PathVariable String username, @PathVariable String bankAccountNumber) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		
		BankAccount bankAccount = bankAccountRepository.findByAccountNumber(bankAccountNumber);
		
		if (bankAccount == null || (bankAccount != null && bankAccount.getCustomerId() != appAccount.getCustomerId())) {
			return new ArrayList<>();
		}
		
		List<Transaction> transactions = transactionRepository.findAllByFromAccountNumber(bankAccountNumber);
		
		transactions.addAll(transactionRepository.findAllByToAccountNumber(bankAccountNumber));
		
		Comparator<Transaction> comparatorDesc = (trans1, trans2) -> trans1.getIssueDate()
                .compareTo(trans2.getIssueDate());
		
		Collections.sort(transactions, comparatorDesc);
		
		
		return transactions;
	}
	
	//---------------------------------------------------------------------------------------------
	
	@PostMapping("/{username}/transaction")
	public ResponseEntity<String> createTransaction(@PathVariable String username, @RequestBody Transaction transaction) {
		// Validate sufficient funds
		if (transaction.getAmount() < 0) {
			return new ResponseEntity<>(
			          "Negative amount not allowed", 
			          HttpStatus.BAD_REQUEST);
		}
		
		BankAccount fromAccount = bankAccountRepository.findByAccountNumber(transaction.getFromAccountNumber());
		BankAccount toAccount = bankAccountRepository.findByAccountNumber(transaction.getToAccountNumber());
		if (fromAccount != null && fromAccount.getBalance() < transaction.getAmount()) {
			return new ResponseEntity<>(
			          "Insufficient funds", 
			          HttpStatus.BAD_REQUEST);
		}
		
		fromAccount.withdraw(transaction.getAmount());
		
		if (toAccount != null) {
			Double actualAmount = transaction.getAmount() * transaction.getExchangeRate();
			Double convertedAmount = Math.floor(actualAmount * 100) / 100;
			toAccount.deposit(convertedAmount);
		}
		
		transaction.setId(null);
		transaction.setIssueDate(LocalDate.now());
		transactionRepository.save(transaction);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@PostMapping("/{username}/account/checking/{currency}")
	public BankAccount createCheckingAccount(@PathVariable String username, @PathVariable Integer currency) {
		BankAccount newAccount = new BankAccount();
		
		String generatedBankAccount = Generator.generateBankAccount();
		while (bankAccountRepository.findByAccountNumber(generatedBankAccount) != null) {
			generatedBankAccount = Generator.generateBankAccount();
		}			
		newAccount.setAccountNumber(generatedBankAccount);
		
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		newAccount.setCustomerId(appAccount.getCustomerId());
		
		newAccount.setBalance(0.);
		newAccount.setAccountName("Checking account");
		newAccount.setType(BankAccountType.CHECKING);
		if (currency < BankAccountCurrency.values().length) {
			newAccount.setCurrency(BankAccountCurrency.values()[currency]);
		}
		
		return bankAccountRepository.save(newAccount);
	}
	
	@PostMapping("/{username}/account/savings")
	public BankAccount createSavingsAccount(@PathVariable String username) {
		BankAccount newAccount = new BankAccount();
		
		String generatedBankAccount = Generator.generateBankAccount();
		while (bankAccountRepository.findByAccountNumber(generatedBankAccount) != null) {
			generatedBankAccount = Generator.generateBankAccount();
		}			
		newAccount.setAccountNumber(generatedBankAccount);
		
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		newAccount.setCustomerId(appAccount.getCustomerId());
		
		newAccount.setBalance(0.);
		newAccount.setAccountName("Savings account");
		newAccount.setType(BankAccountType.SAVINGS);
		
		newAccount.setCurrency(BankAccountCurrency.CHF);
		
		
		return bankAccountRepository.save(newAccount);
	}
	
	@PostMapping("/{username}/card")
	public Card createVirtualCard(@PathVariable String username, @RequestBody String accountNumber) {
		BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
		if (bankAccount == null) {
			return null;
		}
		
		Card newCard = new Card();
		
		String generatedCardNumber = Generator.generateCardNumber();
		while (cardRepository.findByCardNumber(generatedCardNumber) != null) {
			generatedCardNumber = Generator.generateCardNumber();
		}
		newCard.setAccountNumber(accountNumber);
		
		newCard.setCvv(Generator.generateCVV());
		newCard.setPin(Generator.generatePIN());
		newCard.setAvailabilityDate(null);
		newCard.setType(CardType.VIRTUAL);
		newCard.setCardName("Virtual " + bankAccount.getCurrency().toString());
		
		return cardRepository.save(newCard);
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Transactional
	@DeleteMapping("/{username}/accounts/{accountNumber}")
	public ResponseEntity<Void> deleteBankAccount(@PathVariable String username, @PathVariable String accountNumber) {
		// Validate that account belongs to user
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
		if (bankAccount.getBalance() > 0) {
			return ResponseEntity.badRequest().build();
		}
		
		if (appAccount != null && bankAccount != null && appAccount.getCustomerId() == bankAccount.getCustomerId()) {
			bankAccountRepository.deleteByAccountNumber(accountNumber);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
	
	//---------------------------------------------------------------------------------------------
	
	@PutMapping("/{username}/accounts/{accountNumber}")
	public ResponseEntity<Void> updateBankAccountName(@PathVariable String username,
													  @PathVariable String accountNumber,
													  @RequestBody Map<String, String> payload) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
		if (appAccount == null || bankAccount == null) {
			return ResponseEntity.badRequest().build();
		}
		if (appAccount.getCustomerId() != bankAccount.getCustomerId()) {
			return ResponseEntity.badRequest().build();
		}
		if (payload.get("name") != null) {
			bankAccount.setAccountName(payload.get("name"));
			bankAccountRepository.save(bankAccount);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/{username}/cards/{id}/activate")
	public Card updateCardActivate(@PathVariable String username, @PathVariable String id) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		Card card = cardRepository.findByCardNumber(id);
		if (appAccount == null || card == null) {
			return null;
		}
		BankAccount bankAccount = bankAccountRepository.findByAccountNumber(card.getAccountNumber());
		if (bankAccount != null && appAccount.getCustomerId() == bankAccount.getCustomerId()) {
			card.setStatus(CardStatus.ACTIVE);
			cardRepository.save(card);
			return card;
		}
		return null;
	}
	
	@PutMapping("/{username}/cards/{id}/deactivate")
	public Card updateCardDeactivate(@PathVariable String username, @PathVariable String id) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		Card card = cardRepository.findByCardNumber(id);
		if (appAccount == null || card == null) {
			return null;
		}
		BankAccount bankAccount = bankAccountRepository.findByAccountNumber(card.getAccountNumber());
		if (bankAccount != null && appAccount.getCustomerId() == bankAccount.getCustomerId()) {
			card.setStatus(CardStatus.INACTIVE);
			cardRepository.save(card);
			return card;
		}
		return null;
	}
	
	@PutMapping("/{username}/passcode")
	public ResponseEntity<Void> updateUserPasscode(@PathVariable String username, @RequestBody Map<String, String> payload) {
		AppAccount appAccount = appAccountRepository.findByUsername(username);
		if (appAccount == null) {
			return ResponseEntity.badRequest().build();
		}
		if (payload.get("passcode") != null) {
			appAccount.setPasscode(payload.get("passcode"));
			appAccountRepository.save(appAccount);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}

//	@PutMapping("/users/{username}/todos/{id}")
//	public BankAccount updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody BankAccount bankAccount) {
//		bankAccountRepository.save(bankAccount);
//		return bankAccount;
//	}
}
