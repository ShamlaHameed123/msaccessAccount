package com.nagarro.techassignment.servImpl;

import java.text.DateFormat;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.techassignment.dto.RequestDTO;
import com.nagarro.techassignment.dto.StatementDto;
import com.nagarro.techassignment.entity.Account;
import com.nagarro.techassignment.entity.Statement;
import com.nagarro.techassignment.repository.AccountRepository;
import com.nagarro.techassignment.repository.StatementRepository;
import com.nagarro.techassignment.service.StatementService;

@Service
public class StatementServiceImpl implements StatementService{
	
	@Autowired
	StatementRepository statementRepository;
	
	@Autowired
	AccountRepository accountRepository;
	

	@Override
	public List<Statement> getAdvancedFilteredStatement(long accountID, Date fromDate, Date toDate, double fromAmount,
			double toAmount) {
		
		return statementRepository.getAdvancedFilteredStatementWithDateAndAmount(accountID, fromDate, toDate, fromAmount, toAmount);
	}
	
	@Override
	public List<Statement> getFilterByDateStatement(long accountID, Date fromDate, Date toDate) {
		
		return statementRepository.getStatementWithDateRange(accountID, fromDate, toDate);
	}
	
	@Override
	public List<Statement> getFilterByAmountStatement(long accountID,double fromAmount, double toAmount) {
		
		return statementRepository.getStatementWithAmountRange(accountID, fromAmount, toAmount);
	}

	@Override
	public List<Statement> getThreeMonthBackStatement(Long accountID) throws ParseException {
//		Date currentDate=new SimpleDateFormat("dd.MM.yyyy").parse("09.08.2012"); //sample date given since
		Date currentDate = new Date();
		Date toDate = DateUtils.addMonths(currentDate, -3);
		List<Statement> statements = statementRepository.getStatementWithDateRange(accountID, currentDate, toDate);
		return statements;
	}

}
