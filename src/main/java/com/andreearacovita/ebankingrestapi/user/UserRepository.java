package com.andreearacovita.ebankingrestapi.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<EbankingUser, Long> {

    EbankingUser findByUsername(String username);
}
