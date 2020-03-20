package com.company.Customer.entity;


import java.util.Collection;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="roles")
public class Role {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer role_id;
	private String name;
	@ManyToMany(mappedBy="roles")
	private Collection<Customer> customers;
	
	
	@ManyToMany
	@JoinTable(name="roles_privileges",
	joinColumns= {@JoinColumn(name="role_id",referencedColumnName="role_id")},
	inverseJoinColumns= {@JoinColumn(name="privilege_id",referencedColumnName="privilege_id")})
	private Collection<Privilege> privileges; 
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Customer> getUsers() {
		return customers;
	}
	public void setUsers(Collection<Customer> users) {
		this.customers = users;
	}
	public Collection<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	 
}
