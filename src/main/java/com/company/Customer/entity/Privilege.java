package com.company.Customer.entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Privilege {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long privilege_id;
 
    private String name;
    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
	public Long getPrivilege_id() {
		return privilege_id;
	}
	public void setPrivilege_id(Long privilege_id) {
		this.privilege_id = privilege_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}


}
