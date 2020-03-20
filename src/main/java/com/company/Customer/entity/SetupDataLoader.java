package com.company.Customer.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.company.Customer.repository.LoginRepository;
import com.company.Customer.repository.PrivilegeRepository;
import com.company.Customer.repository.RoleRepository;

public class SetupDataLoader  implements
ApplicationListener<ContextRefreshedEvent>{

//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		// TODO Auto-generated method stub
//		
//	}
	boolean alreadySetup = false;
	 
    @Autowired
    private LoginRepository userRepository;
  
    @Autowired
    private RoleRepository roleRepository;
  
    @Autowired
    private PrivilegeRepository privilegeRepository;
//  
//    @Autowired
//    private PasswordEncoder passwordEncoder;
  
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
  
        if (alreadySetup)
            return;
        Privilege readPrivilege
          = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
          = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
  
        List<Privilege> adminPrivileges = Arrays.asList(
          readPrivilege, writePrivilege);        
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));
 
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        Customer user = new Customer();
        
        user.setPassword("test");
        user.setEmail("test@test.com");
        user.setRoles(Arrays.asList(adminRole));
        //user.setEnabled(true);
        userRepository.save(user);
 
        alreadySetup = true;
    }
 
    @Transactional
    private Privilege createPrivilegeIfNotFound(String name) {
  
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege();
            privilegeRepository.save(privilege);
        }
        return privilege;
    }
 
    @Transactional
    private Role createRoleIfNotFound(
      String name, Collection<Privilege> privileges) {
  
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role();
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
