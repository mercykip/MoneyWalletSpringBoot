package com.company.Customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.Customer.entity.Transaction;

public interface TransactionnRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findAllByCustomerId(Integer ndi);




}
