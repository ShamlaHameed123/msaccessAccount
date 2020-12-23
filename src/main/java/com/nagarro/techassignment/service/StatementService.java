package com.nagarro.techassignment.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.techassignment.dto.RequestDTO;
import com.nagarro.techassignment.dto.StatementDto;
import com.nagarro.techassignment.entity.Statement;


public interface StatementService {
	
	public List<Statement> getThreeMonthBackStatement(Long accountID, Date date1) throws ParseException;
	public List<StatementDto> getFilteredStatement(long accountID, RequestDTO dateRange, float fromAmount, float toAmount);


}
