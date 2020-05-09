package com.company.Customer.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer customerId;
	    private String customerName;
	    private String accountNumber;
	    private String username;
	    private String email;
	    private String pin;
	    private String confirmPin;
	    // user roles
	 @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	 @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "customerId"))
	 @Enumerated(EnumType.STRING)
	    private Set<Role> roles;
	@JsonManagedReference
	@OneToOne(mappedBy = "customer")
	    private Account account;
		  // if user is admin
	    public boolean isAdmin() {
	        return roles.contains(Role.ADMIN);
	    }
	   public Set<Role> getRoles() {
				return roles;
			}
		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
	    public Account getAccount() {
			return account;
		}
		public void setAccount(Account account) {
			this.account = account;
		}
		public Customer() {
		}
		  
		public Customer(Customer customer) {
					this.customerName=customer.getCustomerName();
					this.email=customer.getEmail();
					this.username=customer.getUsername();
					this.roles=customer.getRoles();
					this.confirmPin=customer.getConfirmPin();
					this.confirmPin=customer.getPin();
					this.customerId=customer.getCustomerId();
				}

		public Customer(Integer customerId, String customerName, String nationalId, String username,String accountNumber, String gender,
				String email, Integer phoneNumber, String address, String pin, String passsword,String confirmPin) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.username = username;
			this.accountNumber = accountNumber;
			this.email = email;	
	        this.pin = pin;
			this.confirmPin = confirmPin;
		
		}

		public Integer getCustomerId() {
			return customerId;
		}

		public void setCustomer_id(Integer customerId) {
			this.customerId = customerId;
		}
		
		public String getAccountNumber() {
				return accountNumber;
			}
		public String setAccountNumber(String accountNumber) {
				return this.accountNumber = accountNumber;
			}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getEmail() {
			return email;
		}

		public String setEmail(String email) {
			return this.email = email;
		}
		public String getPin() {
			return pin;
		}
		public void setPin(String pin) {
			this.pin = pin;
		}
		public String getConfirmPin() {
			return confirmPin;
		}
		public void setConfirmPin(String confirmPin) {
			this.confirmPin= confirmPin;
		}

}
