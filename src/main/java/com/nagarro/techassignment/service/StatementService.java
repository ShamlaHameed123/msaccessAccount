package com.nagarro.techassignment.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.techassignment.dto.RequestDTO;
import com.nagarro.techassignment.dto.StatementDto;
import com.nagarro.techassignment.entity.Statement;


public interface StatementService {
	
	public List<Statement> getThreeMonthBackStatement(Long accountID) throws ParseException;

	public List<Statement> getAdvancedFilteredStatement(long accountID, LocalDate fromDate, LocalDate toDate, double fromAmount,
			double toAmount);

	public List<Statement> getFilterByDateStatement(long accountID, LocalDate fromDate, LocalDate toDate);


	public List<Statement> getFilterByAmountStatement(long accountID, double fromAmount, double toAmount);



}
