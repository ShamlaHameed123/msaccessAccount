package com.nagarro.techassignment.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nagarro.techassignment.converter.AmountStringAttributeConverter;
import com.nagarro.techassignment.converter.DateAttributeConverter;

@Entity
@Table(name="Statement")
public class Statement {
	 
	    @Id
	    @GeneratedValue
	    @Column(name="ID")
	    private Long id;
	     
	    @Column(name="account_id")
	    private Long accountId;
	     

		@Column(name="datefield")
	    @Convert(converter = DateAttributeConverter.class)
		@DateTimeFormat(pattern = "dd.MM.yyyy")
		@JsonFormat(pattern="dd.MM.yyyy", timezone="UTC")
	    private LocalDate dateField;
	    
		public void setDateField(LocalDate dateField) {
			this.dateField = dateField;
		}

		@Column(name="amount")
		@Convert(converter = AmountStringAttributeConverter.class)
	    private double amount;
		

		public double getAmount() {
			return amount;
		}

		
	   public void setAmount(double amount) {
			this.amount = amount;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getAccountId() {
			return accountId;
		}

		public void setAccountId(Long accountId) {
			this.accountId = accountId;
		}


		public LocalDate getDateField() {
			return dateField;
		}



}
