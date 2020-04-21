package com.company.Customer. security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.company.Customer.repository.LoginRepository;
import com.company.Customer.service.CustomeUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses=LoginRepository.class)
@EnableGlobalMethodSecurity(
prePostEnabled = true,
securedEnabled = true, 
jsr250Enabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter{
	//very important   https://www.youtube.com/watch?v=egXtoL5Kg08
    @Autowired
	private CustomeUserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(getPasswordEncoder()); 
	}
	//secure http
@Override
protected void	configure( HttpSecurity http) throws Exception{
	  http.csrf().disable().authorizeRequests()
      .antMatchers("/").permitAll()
      .antMatchers(HttpMethod.POST,"/registration").permitAll()
      .antMatchers(HttpMethod.POST, "/login").permitAll()
      .antMatchers(HttpMethod.GET,"/view").permitAll()
      //.antMatchers(HttpMethod.GET,"/view").hasRole("USER")
       .antMatchers(HttpMethod.GET,"/exploreCourse").permitAll()
      .anyRequest().authenticated();
}
			
private PasswordEncoder getPasswordEncoder() {
return  new PasswordEncoder() {
			@Override
			public String encode(CharSequence charSequence) {
				// TODO Auto-generated method stub
				return  charSequence.toString() ;
			}

			@Override
			public boolean matches(CharSequence charSequence, String s) {
				// TODO Auto-generated method stub
				return true;
			}
			
		};
	     
		
	}
	
	
	
}

