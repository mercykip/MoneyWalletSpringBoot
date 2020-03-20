//package security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.company.Customer.dto.MyUserDetailService;
////import com.company.Customer.entity.Roles;
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfigurer extends WebSecurityConfigurerAdapter{
//	@Autowired
//    private MyUserDetailService userDetailsService;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//	      auth.userDetailsService(userDetailsService);
//	}
//	/**
//	 *
//	 */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
//		//http.csrf().disable()
//		//.antMatcher("/secure/**")'
////		.authorizeRequests()
////		.antMatchers("/8061/registration").hasRole("USER")
////		.antMatchers("/8061/view/**").hasRole("Admin")
////		.antMatchers("/8061/login").hasAnyRole("Admin","User")
////		.and()
////		.httpBasic();
//	//	.hasRoles(Roles.User.name);
//		// http.formLogin().loginPage("/auth").permitAll();
//	}
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception{
//		return super.authenticationManagerBean();
//	}
////	//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//}
