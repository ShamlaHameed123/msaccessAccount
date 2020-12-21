package com.nagarro.techassignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Statement")
public class Statement {
	 
	    @Id
	    @GeneratedValue
	    @Column(name="ID")
	    private Long id;
	     
	    @Column(name="account_id")
	    private String accountId;
	     
	    @Column(name="datefield")
	    private String dateField;
	    
	    @Column(name="amount")
	    private String amount;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAccountId() {
			return accountId;
		}

		public void setAccountId(String accountId) {
			this.accountId = accountId;
		}

		public String getDateField() {
			return dateField;
		}

		public void setDateField(String dateField) {
			this.dateField = dateField;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}
}
