package com.andreearacovita.ebankingrestapi.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreearacovita.ebankingrestapi.customer.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {

	Customer findByOasi(String string);

	Optional<Customer> findById(Long customerId);

}
