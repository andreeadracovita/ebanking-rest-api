package com.andreearacovita.ebankingrestapi.ebankingaccount;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class EBankingAccount {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String userId;
	
	private String password;
	
	private Integer customerId;

	public EBankingAccount(Integer id, String userId, String password, Integer customerId) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.customerId = customerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}
