package com.company.Customer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.Customer.entity.Account;
@Repository 
public interface AccountRepository extends JpaRepository<Account,Integer> {

}
