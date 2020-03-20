package com.company.Customer.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.company.Customer.entity.Account;
import com.company.Customer.entity.Customer;
import com.company.Customer.entity.Transaction;
import com.company.Customer.repository.AccountRepository;
import com.company.Customer.repository.CustomerRepository;
import com.company.Customer.repository.LoginRepository;
import com.company.Customer.repository.TransactionRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
public class AccountController {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	LoginRepository loginRepository;

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	TransactionRepository transactionRepository;
	@GetMapping("/balance/{id}")
	//@RequestMapping(value = "/balance/{id}", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE,"application/x-www-form-urlencoded"}, produces = MediaType.APPLICATION_JSON_VALUE)
	//@GetMapping(value = "/balance/{id}")
	//public ResponseEntity<?>  depositFund(@PathVariable("id") Integer account_id,@RequestBody Account account, Customer customerJson,String colm) {
	@Transactional
	public ResponseEntity<?> checkBalance(@PathVariable("id") Integer customer_id,@ModelAttribute  Customer customerJson,Account account,Transaction transaction) {
		
		 Account cs=accountRepository.getOne(customer_id);
		
		// Customer cus=loginRepository.getOne(C)
		 Gson gson = new Gson();
		 String name=cs.getCustomer().getUsername();
		Integer amount= cs.getAmount();
		 System.out.println("????????????????????"+name);
		JsonObject responseObj = new JsonObject();
		responseObj.addProperty("response_status", true);
		responseObj.addProperty("response_message", "success");
		responseObj.addProperty("username", name);
		responseObj.addProperty("amount", amount);
		//responseObj.addProperty("response_customer", cust1);
		//responseObj.addProperty("pin", pin);
		return ResponseEntity.ok(gson.toJson(responseObj));
		//return	new ResponseEntity<>("balance" +amount, HttpStatus.OK);
		 
	}
	
	//CashWithdrawal
	@RequestMapping (value="/cashWithdrawal/{id}" ,method = RequestMethod.PUT ,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE,"application/x-www-form-urlencoded"},produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> cashWithdrawal(@PathVariable("id")Integer customer_id, @ModelAttribute Account account,Customer customer,Transaction transaction){
		Gson gson = new Gson();
		JsonObject responseObj = new JsonObject();
		Integer pinf = customer.getPin();//reqObj.get("name").getAsString();
		Customer pins=loginRepository.findByPin(customer.getPin());
		System.out.println(pins);
		Integer tax=3;
		Integer charges=1;
		Integer amount=account.getAmount();//amount to withdraw
		Account custAcc=accountRepository.getOne(customer_id);
		String acccId=custAcc.getCustomer().getUsername();
		String s = "withdraw";
		String transactionType;
		      
		Integer dbAmount= custAcc.getAmount();

		if(dbAmount>amount ) {
			Integer total=dbAmount-amount;
			if(total>charges ) {
		 //charges1=(total*charges)/100;
				Integer dbBalance1=total-charges;
				if(dbBalance1>tax) {
					 Integer dbTotal=dbBalance1-tax;
					  Integer btotal=custAcc.setAmount(dbTotal);
					  Integer btax=custAcc.setTax(tax);
					  Integer bcharges=custAcc.setCharges(charges);
					                   // transaction.getAccount().setAccount_id(acccId);
					  //set date
					  DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
					  Date dateobj = new Date();
					 String dateOne=(df.format(dateobj));
					  
					                    transaction.setAmount(amount);
					                    transaction.setUsername(acccId);
					                    transaction.setTrasactionType(s);
					                    transaction.setCharges(bcharges);
					                    transaction.setAccountBalance(dbTotal);
					                    transaction.setDate(dateOne);
					                    transactionRepository.save(transaction);
					  accountRepository.save(custAcc);
					 //Transaction 
					 
						responseObj.addProperty("response_status", true);
						responseObj.addProperty("response_message", "success");
						responseObj.addProperty("response_pin", pinf);
						responseObj.addProperty("response_tax", btax);
						responseObj.addProperty("response_charges", bcharges);
						responseObj.addProperty("response_balance", btotal);
						System.out.println("amount"+amount+"dbamount"+dbAmount+"total "+dbTotal);
						//return ResponseEntity.ok(gson.toJson(responseObj));
						return ResponseEntity.ok(gson.toJson(responseObj));
				
				}
			}
		}
		else {
			return	new ResponseEntity<>("insufficient amount", HttpStatus.OK);
		}
		return	new ResponseEntity<>("Error!Please contact customer care", HttpStatus.OK);		
	}
	
	@RequestMapping (value="/fundTransfer/{id}" ,method = RequestMethod.PUT ,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE,"application/x-www-form-urlencoded"},produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> fundTransfer(@PathVariable("id")Integer customer_id, @ModelAttribute Account account,Customer customer){
		//sender
		Account customer1=accountRepository.getOne(customer_id);
		Gson gson = new Gson();
		
//		String accnoF=customer.getAccount_number();
		String accnoR=customer.getAccountNumber();//Account no.ofReceiver
		Customer c2=customerRepository.findByAccountNumber(customer.setAccountNumber(accnoR));
		Integer amountS=customer1.getAmount();//Sender initial db amount
		Integer amountR=c2.getAccount().getAmount();
		Integer amountF=account.getAmount();//Amount being sent
		Integer dbAmountR=amountR+amountF;//Receiver db balance 
		Integer dbAmountS=amountS-amountF;
	Integer sender=	customer1.setAmount(dbAmountS);
		Integer receiver=c2.getAccount().setAmount(dbAmountR);
		accountRepository.save(customer1);
		customerRepository.save(c2);
		
//		Customer c1=customerRepository.findByEmail(customer.setEmail(accnoF));
		JsonObject responseObj = new JsonObject();
		responseObj.addProperty("response_status", true);
		responseObj.addProperty("response_message", "success");
		responseObj.addProperty("ReceiverAccountNumber",  accnoR);
		responseObj.addProperty("SendingAmount", amountF);
		//responseObj.addProperty("response_customer", cust1);
		responseObj.addProperty("ReceiverBalance", receiver);
		responseObj.addProperty("SenderBalance", sender);
		return ResponseEntity.ok(gson.toJson(responseObj));
		//Integer amountF=account.getAmount();
	    //String accnoF=customer.getAccount_number();
		
		//Receiver
	     
	       // System.out.println("????????????????????"+customer2);
//	        if(customer2!=null) {
//	         return  new ResponseEntity<>("user" + customer2, HttpStatus.OK);
//	        }
//	        else {
//	        	  return  new ResponseEntity<>("User does not exist" , HttpStatus.OK);
//	        }
	
    //    Customer customer2=loginRepository.findByAccount(customer.setAccount_number(accnoF));
        
       // String accnoF=account.getCustomer().getAccount_number();
      
//   return null;
        
//    Integer totol=amount-dbAmount;
//    customer1.setAmount(totol);
//    accountRepository.save(customer1);
//    System.out.println("total"+totol);
//      return  new ResponseEntity<>("Total" + totol, HttpStatus.OK);
      
	
			
	
			
		  
				  
		
		
		
				
		
		
		
	
	}
	
}
