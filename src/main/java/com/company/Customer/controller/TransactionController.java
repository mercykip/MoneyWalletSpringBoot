package com.company.Customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.company.Customer.entity.Customer;
import com.company.Customer.entity.Transaction;
import com.company.Customer.repository.TransactionRepository;
import com.company.Customer.repository.TransactionnRepository;
@RestController
@CrossOrigin
public class TransactionController {
@Autowired
TransactionRepository transactionRepository;
@Autowired
TransactionnRepository  transactionnRepository;

//Get all transactions
@GetMapping("/viewTransaction")
public List<Transaction> getAllCustomers(Transaction transaction)
{
	transactionRepository.findAll();		
	System.out.println(	transactionRepository.findAll());
	return transactionRepository.findAll();
	
}
@GetMapping("/miniStatement/{id}")
public List<Transaction> getAllTransaction(@PathVariable("id")Integer customerId,Transaction transaction)
{
	
//	Transaction tnId=transactionnRepository.getOne(customerId);
//	Integer ndi=tnId.getCustomerId();
	List<Transaction> tb=transactionnRepository.findAllByCustomerId(customerId);
	return tb;

	
	
}
}
