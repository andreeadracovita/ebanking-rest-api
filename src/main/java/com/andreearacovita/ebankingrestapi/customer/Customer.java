package com.andreearacovita.ebankingrestapi.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String oasi;
	
	public Customer() {}

	public Customer(Long id, String firstName, String lastName, String oasi) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.oasi = oasi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOasi() {
		return oasi;
	}

	public void setOasi(String oasi) {
		this.oasi = oasi;
	}
}
