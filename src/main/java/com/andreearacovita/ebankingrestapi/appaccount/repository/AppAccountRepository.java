package com.andreearacovita.ebankingrestapi.appaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreearacovita.ebankingrestapi.appaccount.AppAccount;

public interface AppAccountRepository  extends JpaRepository<AppAccount, Integer> {

	AppAccount findByUsername(String username);
}
