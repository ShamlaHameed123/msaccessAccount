package com.nagarro.techassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.techassignment.entity.Account;

@Repository
public interface AccountRepository 
        extends JpaRepository<Account, Long> {
 
}

