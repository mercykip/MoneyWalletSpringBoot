package com.company.Customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.Customer.entity.Account;
import com.company.Customer.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String>{

	void save(Account account);

}
