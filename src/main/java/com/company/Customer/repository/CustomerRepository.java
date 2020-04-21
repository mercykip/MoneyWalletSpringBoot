package com.company.Customer.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.company.Customer.entity.Customer;




public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByEmail(String email);

	Customer findByAccountNumber(String setAccountNumber);

	Optional<Customer> findByUsername(String username);

	




	

	




	






	
}
