package com.andreearacovita.ebankingrestapi.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreearacovita.ebankingrestapi.customer.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {

}
