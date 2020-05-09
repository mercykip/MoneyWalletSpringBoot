package com.company.Customer.controller;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

import com.company.Customer.entity.Account;
import com.company.Customer.entity.Customer;
import com.company.Customer.entity.Role;
import com.company.Customer.entity.Transaction;
import com.company.Customer.repository.AccountRepository;
import com.company.Customer.repository.CustomerRepository;
import com.company.Customer.repository.LoginRepository;
//simport com.company.Customer.repository.RoleRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
//@RequestMapping("/book")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	LoginRepository loginRepository;
	@Autowired
    AccountRepository accountRepository;
	
	
	@GetMapping("/admin")
	public String getCu() 
	{
         return ("Hello admin");
		
	}
	@GetMapping("/user")
	public String getCust() 
	{
        return ("Hello user");
	}
	
  @RequestMapping(value = "/registrationForm", method = RequestMethod.GET)
  public String registrationForm() {
      return "registrationForm";
  }

  
	@RequestMapping(value = "/registration", method = RequestMethod.POST, 
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE,"application/x-www-form-urlencoded"}, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> registration(@ModelAttribute Customer customerJson ,Account account,Transaction transaction,Role role)
	{
		Gson gson = new Gson();
			String name = customerJson.getCustomerName();//reqObj.get("name").getAsString();
			String email = customerJson.getEmail();//reqObj.get("name").getAsString();
			String account_number = customerJson.getAccountNumber();//reqObj.get("name").getAsString();
			String user = customerJson.getUsername();//reqObj.get("name").getAsString();
			String confirmpin = customerJson.getPin();//reqObj.get("name").getAsString();
			String pin = customerJson.getConfirmPin();//reqObj.get("name").getAsString();
			Set<Role> roles=customerJson.getRoles();
			System.out.println("the nameis "+name);
		//Create accunt
			Integer customerId=customerJson.getCustomerId();
			Integer amount=0;
			Integer amountc=account.setAmount(amount);
			Integer amountt=transaction.setAmount(amount);
			Customer c=account.setCustomer(customerJson);
			System.out.println(c+"????????????????????");
			System.out.println( amountc+"????????????????????");
		/// Save to DB	
			customerJson.setRoles(Collections.singleton(Role.USER));
			Customer users=customerRepository.save(customerJson);
			accountRepository.save(account);
		    account.setAmount(0);
		if(users!=null) 
		{
			// Send json response	// Send json response
			JsonObject responseObj = new JsonObject();
			responseObj.addProperty("response_status", true);
			responseObj.addProperty("response_message", "success");
			responseObj.addProperty("response_name", name);
			responseObj.addProperty("response_email", email);
			responseObj.addProperty("response_account_number", account_number);
			responseObj.addProperty("response_user", user);
			responseObj.addProperty("response_confirmpin", confirmpin);
			responseObj.addProperty("response_pin", pin);
			return ResponseEntity.ok(gson.toJson(responseObj));
		}
		else
		{
			return	new ResponseEntity<>("Registration failed", HttpStatus.OK);
		}

	}
	//aAdmin Login

	@RequestMapping(value = "/registrationAdmin", method = RequestMethod.POST, 
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE,"application/x-www-form-urlencoded"}, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> registrationAdmin(@ModelAttribute Customer customerJson ,Account account,Transaction transaction,Role role)
	{
		Gson gson = new Gson();
			String name = customerJson.getCustomerName();//reqObj.get("name").getAsString();
			String email = customerJson.getEmail();//reqObj.get("name").getAsString();
			String user = customerJson.getUsername();//reqObj.get("name").getAsString();
			String confirmpin = customerJson.getPin();//reqObj.get("name").getAsString();
			String pin = customerJson.getConfirmPin();//reqObj.get("name").getAsString();
			
		//Create accunt
		
		/// Save to DB	
			customerJson.setRoles(Collections.singleton( Role.ADMIN));
			Customer users=customerRepository.save(customerJson);
			accountRepository.save(account);
		    account.setAmount(0);
		if(users!=null) 
		{
			// Send json response	// Send json response
			JsonObject responseObj = new JsonObject();
			responseObj.addProperty("response_status", true);
			responseObj.addProperty("response_message", "success");
			responseObj.addProperty("response_name", name);
			responseObj.addProperty("response_email", email);
			responseObj.addProperty("response_user", user);
			responseObj.addProperty("response_confirmpin", confirmpin);
			responseObj.addProperty("response_pin", pin);
			return ResponseEntity.ok(gson.toJson(responseObj));
		}
		else
		{
			return	new ResponseEntity<>("Registration failed", HttpStatus.OK);
		}

	}
	@SuppressWarnings("unused")
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {
MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE,"application/x-www-form-urlencoded"},produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<?> CustomerLogin( @ModelAttribute Customer customer)
	{
		Gson gson = new Gson();
			String user = customer.getUsername();//reqObj.get("name").getAsString();
			String pin = customer.getPin();//reqObj.get("name").getAsString();
			System.out.println(user +"user");
			System.out.println(pin +"pin");
		//validate credentials
			Customer cust1= loginRepository.findByUsername(customer.getUsername());
			Integer cid=cust1.getCustomerId();
		if(cust1!=null) {
		JsonObject responseObj = new JsonObject();
			responseObj.addProperty("response_status", true);
			responseObj.addProperty("response_message", "success");
			responseObj.addProperty("response_customerId", cid);
			responseObj.addProperty("response_username", user);
			responseObj.addProperty("response_pin", pin);
		return ResponseEntity.ok(gson.toJson(responseObj));
		 }
	    else {
	    	System.out.println("failed");
	    	return	new ResponseEntity<>("Login failed", HttpStatus.OK);

	    }
	    
}

	//delete customer
	@RequestMapping(value = "/customerDelete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Integer customerId)
	   {
		    customerRepository.deleteById(customerId);
		    return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	   }
	
	//view a specific user
	@GetMapping("/view/{id}")
	public Customer getCustomer(@PathVariable("id") Integer customerId) 
	{
         Customer customer=customerRepository.getOne(customerId);
		 return customer;
		
	}
	//view all users
		@GetMapping(value="/view")
		public List<Customer>  getAllCustomers()
		{
			return  customerRepository.findAll();
		}
	    
		 // update customer
		@RequestMapping(value = "/customerUpdate/{id}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> updateCustomer(@PathVariable("id") Integer customerId,@RequestBody Customer customer)
		{
	    Customer customers=customerRepository.getOne(customerId);	
		    customers.setAccountNumber(customer.getAccountNumber());
		    customers.setEmail(customer.getEmail());
		    customers.setCustomerName(customer.getCustomerName());
		    customerRepository.save(customers);
		return new ResponseEntity<>("customer is updated successsfully", HttpStatus.OK);   
	     }

	
}
