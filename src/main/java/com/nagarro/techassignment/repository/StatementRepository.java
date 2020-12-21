package com.nagarro.techassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.techassignment.entity.Statement;

@Repository
public interface StatementRepository 
        extends JpaRepository<Statement, Long> {
 
}
