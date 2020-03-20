package com.company.Customer.entity;


import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "account")
public class Account implements Serializable {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue()
	    public Integer account_id;
	   // @OneToOne(fetch = FetchType.EAGER, optional = false,cascade=CascadeType.ALL)
	    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	    @JsonBackReference
		@JoinColumn(name = "customer_id") 
	    private Customer customer;
	    
		@OneToOne(mappedBy = "account")
		private Transaction transaction;
		
	    public Integer amount;
	  
		public Integer tax;
	    public Integer charges;
	    public Account() {
		//	super();
			// TODO Auto-generated constructor stub
		}
	    public Account(Integer account_id, Customer customer, Integer amount, Integer tax, Integer charges) {
			super();
			this.account_id = account_id;
			this.customer = customer;
			this.amount = amount;
			this.tax = tax;
			this.charges = charges;
		}
		public Integer getAccount_id() {
			return account_id;
		}
		public void setAccount_id(Integer account_id) {
			this.account_id = account_id;
		}
		public Customer getCustomer() {
			return customer;
		}
		public Customer setCustomer(Customer customer) {
			return this.customer = customer;
		}
		public Integer getAmount() {
			return amount;
		}
		public Integer setAmount(Integer amount) {
			return this.amount = amount;
		}
		public Integer getTax() {
			return tax;
		}
		public Integer setTax(Integer tax) {
			return this.tax = tax;
		}
		public Integer getCharges() {
			return charges;
		}
		public Integer setCharges(Integer charges) {
			return this.charges = charges;
		}
	    
	    
		
		
}
