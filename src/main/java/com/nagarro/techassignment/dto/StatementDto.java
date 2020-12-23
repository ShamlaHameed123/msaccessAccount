package com.nagarro.techassignment.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StatementDto {
	
	private long accountID;
	private String amount;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private String date;
	private String accountNumber;
	
    public StatementDto(long accountID, String date, String amount, String accountNumber) {
		
		this.accountID = accountID;
		this.date = date;
		this.amount = amount;
		this.accountNumber = accountNumber;
	}
	
	public StatementDto() {
		
	}
	
	
	public long getAccountID() {
		return accountID;
	}
	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

}
