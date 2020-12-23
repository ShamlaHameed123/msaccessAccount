package com.nagarro.techassignment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	    private Date dateField;
	    
		@Column(name="amount")
		@Convert(converter = AmountStringAttributeConverter.class)
	    private double amount;
		
		public void setDateField(Date dateField) {
				this.dateField = dateField;
		}
		
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

		public Date getDateField() {
			return dateField;
		}


}
