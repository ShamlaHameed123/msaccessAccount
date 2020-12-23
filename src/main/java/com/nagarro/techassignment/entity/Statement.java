package com.nagarro.techassignment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	    
	    public void setDateField(Date dateField) {
			this.dateField = dateField;
		}

		@Column(name="amount")
	    private String amount;

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

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}
}
