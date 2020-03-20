package com.company.Customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.company.Customer.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String>{

	Role findByName(String string);

}
