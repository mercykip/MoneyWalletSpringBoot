package com.company.Customer.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "transact")
public class Transaction {
	@Id
    @GeneratedValue()
	private Integer transaction_id;
	   //@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
        @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		@JoinColumn(name = "account_id") 
	    private Account account;
        
        private String username;
		private Integer amount;
		private Integer charges;
		private String date;
		private Integer accountBalance;
        private String trasactionType;
	public Account getAccount() {
			return account;
		}
		public void setAccount(Account account) {
			this.account = account;
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
	
	//    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//	@JoinColumn(name = "customer_id") 
//    private Customer customer;
//    
//	public Customer getCustomer() {
//		return customer;
//	}
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	public Integer getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Integer transaction_id) {
		this.transaction_id = transaction_id;
	}
	

}
