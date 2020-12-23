package com.nagarro.techassignment.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.aspectj.apache.bcel.ExceptionConstants;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class RequestDTO {
	
	@NotNull(message="Start date should be specified")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date startDate;
	
	@NotNull(message="End date should be specified")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date endDate;


	public RequestDTO(Date startDate, Date endDate) {
		
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public RequestDTO() {
		
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
