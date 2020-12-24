package com.nagarro.techassignment.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.techassignment.entity.Statement;

@Repository
public interface StatementRepository 
        extends JpaRepository<Statement, Long> {
	
	@Query("SELECT s FROM Statement s WHERE s.accountId=:accountId AND (s.dateField > :fromDate OR s.dateField < :toDate)")
	public List<Statement> getStatementWithGivenDateRange(@Param("accountId") Long accountId, @Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);
	
	@Query("SELECT s FROM Statement s WHERE s.accountId=:accountId AND ((s.dateField > :fromDate OR s.dateField < :toDate) AND (s.amount > :fromAmount OR s.amount < :toAmount))")
	public List<Statement> getAdvancedFilteredStatementWithDateAndAmount(@Param("accountId") Long accountId, 
														@Param("fromDate") LocalDate fromDate, 
															@Param("toDate") LocalDate toDate,
															@Param("fromAmount") double fromAmount, 
															@Param("toAmount") double toAmount);
	
	@Query("SELECT s FROM Statement s WHERE s.accountId=:accountId AND (s.amount > :fromAmount OR s.amount < :toAmount)")
	public List<Statement> getStatementWithAmountRange(@Param("accountId") Long accountId,
			@Param("fromAmount") double fromAmount, 
			@Param("toAmount") double toAmount);
 
}
