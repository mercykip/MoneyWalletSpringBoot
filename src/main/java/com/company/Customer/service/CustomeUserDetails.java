package com.company.Customer.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.company.Customer.entity.Customer;
import com.company.Customer.repository.CustomerRepository;
import com.company.Customer.repository.LoginRepository;

public class CustomeUserDetails extends Customer implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	LoginRepository loginRepository;

	public CustomeUserDetails(final Customer customer) {
		super(customer);
		
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//	    return getRoles()
//	     .stream()
//	     .map(role-> new SimpleGrantedAuthority("ROLE_"+ role.getRole()))
//	     .collect(Collectors.toList());
//	    
//	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPin();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

}
