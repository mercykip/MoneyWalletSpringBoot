package com.company.Customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.Customer.entity.Account;
import com.company.Customer.entity.Customer;

public interface LoginRepository extends JpaRepository<Customer, String>{

	
//
//	Customer findByPin(Integer pin);
//
//	//Customer findByUsername(String username);
//	Customer findByUsernameAndPin(String username,String pin);

	Customer findByUsername(String username);

	Customer findByPin(Integer pin);

	








	




	

	

	



	





	



}
