package com.company.Customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.Customer.entity.Account;
import com.company.Customer.entity.Customer;

public interface LoginRepository extends JpaRepository<Customer, String>{

	Customer findByUsername(String username);

	Customer findByPin(Integer pin);

	
	String findByAccountNumber(String accountNumber);

}
