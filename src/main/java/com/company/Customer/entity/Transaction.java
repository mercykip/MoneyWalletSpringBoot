package com.company.Customer.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "transaction")
public class Transaction implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "accountId", nullable = true)
    private Account account;
	
        private Integer customerId;
		private String username;
		private Integer amount;
		private Integer charges;
		private String date;
		private Integer accountBalance;
        private String trasactionType;
        
    
		public Integer getCustomerId() {
   			return customerId;
   		}
   		public void setCustomerId(Integer customerId) {
   			this.customerId = customerId;
   		}
	  
		
	   public Integer getCharges() {
			return charges;
		}
	
		public String getTrasactionType() {
		return trasactionType;
		}
		public String setTrasactionType(String trasactionType) {
		return this.trasactionType = trasactionType;
		}
		public void setCharges(Integer charges) {
			this.charges = charges;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String dateOne) {
			this.date = dateOne;
		}
		public Integer getAccountBalance() {
			return accountBalance;
		}
		public void setAccountBalance(Integer accountBalance) {
			this.accountBalance = accountBalance;
		}
	public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public Integer getAmount() {
			return amount;
		}
		public Integer setAmount(Integer amount) {
			return this.amount = amount;
		}
		public Integer getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(Integer transactionId) {
			this.transactionId = transactionId;
		}
	

}
