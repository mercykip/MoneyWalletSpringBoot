package com.company.Customer.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.Customer.entity.Customer;
import com.company.Customer.entity.Privilege;
import com.company.Customer.entity.Role;
import com.company.Customer.repository.LoginRepository;
import com.company.Customer.repository.RoleRepository;


@Service
@Transactional
public class MyUserDetailService implements UserDetailsService{
@Autowired
private LoginRepository loginRepository;
@Autowired
private RoleRepository roleRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
Customer customer=loginRepository.findByUsername(username);
if (customer == null) {
	return new org.springframework.security.core.userdetails.User(
            " ", " ", true, true, true, true, 
            getAuthorities((Customer) Arrays.asList(
              roleRepository.findByName("ROLE_USER"))));

}
return new org.springframework.security.core.userdetails.User(
		customer.getUsername(), customer.getPassword(), true, true, 
        true, false, getAuthorities(customer.getRoles()));
			
	}
	
private Collection<? extends GrantedAuthority> getAuthorities(
		      Collection<Role> roles) {
		  
		        return getGrantedAuthorities(getPrivileges(roles));
		    }

private List<String> getPrivileges(Collection<Role> roles) {
	  
    List<String> privileges = new ArrayList<>();
    List<Privilege> collection = new ArrayList<>();
    for (Role role : roles) {
        collection.addAll(role.getPrivileges());
    }
    for (Privilege item : collection) {
        privileges.add(item.getName());
    }
    return privileges;
}

private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for (String privilege : privileges) {
        authorities.add(new SimpleGrantedAuthority(privilege));
    }
    return authorities;
}

}
