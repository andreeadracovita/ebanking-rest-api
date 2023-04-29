package com.andreearacovita.ebankingrestapi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andreearacovita.ebankingrestapi.user.EbankingUser;

public interface UserRepository extends JpaRepository<EbankingUser, Long> {

    EbankingUser findByUsername(String username);

	EbankingUser findByCustomerId(Long id);
}
