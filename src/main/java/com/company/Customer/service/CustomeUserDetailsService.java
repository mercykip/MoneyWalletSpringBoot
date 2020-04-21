package com.company.Customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.Customer.entity.Customer;
import com.company.Customer.repository.CustomerRepository;

@Service
public class CustomeUserDetailsService  implements UserDetailsService {

	
	@Autowired
	CustomerRepository loginRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	Optional<Customer> optionalCustomers=loginRepository.findByUsername(username);
	
	
	optionalCustomers
			.orElseThrow(()-> new UsernameNotFoundException("User not found"));
	
	
	return optionalCustomers
			.map(CustomeUserDetails::new).get();
			
	}

}
