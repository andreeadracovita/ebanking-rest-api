package com.andreearacovita.ebankingrestapi.appaccount;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AppAccount {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String username;
	
	private String passcode;
	
	private Integer customerId;
	
	public AppAccount() {}

	public AppAccount(Integer id, String username, String passcode, Integer customerId) {
		super();
		this.id = id;
		this.username = username;
		this.passcode = passcode;
		this.customerId = customerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}
