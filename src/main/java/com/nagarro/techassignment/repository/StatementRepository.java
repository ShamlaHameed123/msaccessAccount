package com.nagarro.techassignment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.techassignment.entity.Statement;

@Repository
public interface StatementRepository 
        extends JpaRepository<Statement, Long> {
	
	@Query("SELECT s FROM Statement s WHERE s.accountId=:accountId AND (s.dateField BETWEEN :fromDate AND :toDate)")
	public List<Statement> findThreeMonthBackStatement(@Param("accountId") Long accountId, @Param("fromDate") Date currentDate, @Param("toDate") Date toDate);
//	List<Statement> findFilteredStatementByDateAndAmount(long accountID, Date fromDate, 
//											Date toDate, float fromAmount, float toAmount);
 
}
