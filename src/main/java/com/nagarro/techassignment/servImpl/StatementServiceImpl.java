package com.nagarro.techassignment.servImpl;

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
	public List<StatementDto> getFilteredStatement(long accountID, RequestDTO dateRange, float fromAmount,
			float toAmount) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Statement> getThreeMonthBackStatement(Long accountID, Date currentDate) throws ParseException {
//		Optional<Account> account = accountRepository.findById(accountID);
//		Date fromDate=new SimpleDateFormat("dd.MM.yyyy").parse(currentDate);  
		Date toDate = DateUtils.addMonths(currentDate, 4);
		List<Statement> statements = statementRepository.findThreeMonthBackStatement(accountID, currentDate, toDate);
		return statements;
	}

}
