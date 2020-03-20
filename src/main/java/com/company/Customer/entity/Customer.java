package com.company.Customer.entity;

//import java.util.Collection;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;






//import org.springframework.security.core.GrantedAuthority;



@Entity
@Table(name = "customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements java.io.Serializable, Collection<Role>{
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	   private Integer customer_id;
	 @NonNull
	    private String customerName;
	 @NonNull
	// private Roles role;
//	 @Size(min = 6, max = 6)
	    private Integer  nationalId;
	 @NonNull
//	 @Size(min = 2, max =4 )
	    private String accountNumber;
	 @NonNull
	    private String username;
	 @NonNull
		private String gender;
	 @NonNull
	 @Email 
	    private String email;
	 @NonNull
//	 @Size(min = 10, max = 13)
		private Integer phoneNumber;
	 @NonNull
	    private String address;
	 @NonNull
//	 @Size(min = 4, max = 6)
	    private Integer pin;
	 
//	 @Size(min = 4, max = 6)
	    private String password;
//	 @Size(min = 4, max = 6)
	 @NonNull
	    private Integer confirmPin;
	 @JsonManagedReference
		@OneToOne(mappedBy = "customer")
		  private Account account;
	    
//		@OneToOne(mappedBy = "customer")
//		  private Transaction transaction;
//	    
	    public Account getAccount() {
			return account;
		}


		public void setAccount(Account account) {
			this.account = account;
		}

		public Customer() {
		
		}

		public Customer(Integer customer_id, String customerName, Integer nationalId, String username,String accountNumber, String gender,
				String email, Integer phoneNumber, String address, Integer pin, Integer passsword,Integer confirmPin) {
			super();
			this.customer_id = customer_id;
			this.customerName = customerName;
			this.nationalId = nationalId;
			this.username = username;
			this.accountNumber = accountNumber;
			this.gender = gender;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.pin = pin;
			this.password = password;
			this.confirmPin = confirmPin;
		}
	    
	    
	    
		public Integer getCustomer_id() {
			return customer_id;
		}

		public void setCustomer_id(Integer customer_id) {
			this.customer_id = customer_id;
		}
		
		public String getAccountNumber() {
				return accountNumber;
			}



		public String setAccountNumber(String accountNumber) {
				return this.accountNumber = accountNumber;
			}
		
		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public Integer getNationalId() {
			return nationalId;
		}

		public void setNationalId(Integer nationalId) {
			this.nationalId = nationalId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getEmail() {
			return email;
		}

		public String setEmail(String email) {
			return this.email = email;
		}

		public Integer getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(Integer phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Integer getPin() {
			return pin;
		}

		public void setPin(Integer pin) {
			this.pin = pin;
		}

		public Integer getConfirmPin() {
			return confirmPin;
		}

		public void setConfirmPin(Integer confirmPin) {
			this.confirmPin= confirmPin;
		}

@ManyToMany(cascade=CascadeType.MERGE)
@JoinTable(name="customer_role",
joinColumns= {@JoinColumn(name="customer_id",referencedColumnName="customer_id")},
inverseJoinColumns= {@JoinColumn(name="role_id",referencedColumnName="role_id")})
private List<Role> roles;

public List<Role> getRoles() {
	return roles;
}


public void setRoles(List<Role> roles) {
	this.roles = roles;
}

//
//public Optional<Customer> orElseThrow(Object object) {
//	// TODO Auto-generated method stub
//	return null;
//}


public boolean isEnabled() {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean add(Role arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean addAll(Collection<? extends Role> arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public void clear() {
	// TODO Auto-generated method stub
	
}


@Override
public boolean contains(Object arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean containsAll(Collection<?> arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}


@Override
public Iterator<Role> iterator() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public boolean remove(Object arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean removeAll(Collection<?> arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean retainAll(Collection<?> arg0) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public int size() {
	// TODO Auto-generated method stub
	return 0;
}


@Override
public Object[] toArray() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public <T> T[] toArray(T[] arg0) {
	// TODO Auto-generated method stub
	return null;
}

		
	   
		

		
		 
	

}
