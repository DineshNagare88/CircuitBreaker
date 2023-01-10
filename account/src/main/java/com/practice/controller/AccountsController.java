package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.config.AccountsConfig;
import com.practice.feignclients.CardsFeignClient;
import com.practice.model.Account;
import com.practice.response.Cards;
import com.practice.response.CustomerDetails;
import com.practice.service.AccountService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/accounts")
public class AccountsController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CardsFeignClient cardsFeignClient;
	
	@Autowired
	private AccountsConfig accountsConfig;

	//@PostMapping("myAccount")
	@GetMapping("/{id}")
	public Account fetchAccountDetails(@PathVariable("id") int customerId) {
		log.info("Account Controller-> fetch AccountsDetails customerId {},{}", customerId);
		return accountService.fetchAccountDetails(customerId);

	}
	
	@GetMapping("/myCustomerDetails/{id}")
	//@CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "fallBackCustomerDetails")
	@Retry(name = "${spring.application.name}",fallbackMethod = "fallBackCustomerDetails")
	public CustomerDetails fetchCustomerDetails(@PathVariable("id") int customerId)
	{
		//information of accounts
		//information of cards		
		Account account = accountService.fetchAccountDetails(customerId);
		List<Cards> cards =cardsFeignClient.getCardDetails(customerId);		
		//log.info("HERE");
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setAccount(account);
		customerDetails.setCards(cards);
		return customerDetails;
	}
	
	public CustomerDetails fallBackCustomerDetails(@PathVariable("id") int customerId,Exception ex)
	{
		//information of accounts
		//information of cards		
		Account account = accountService.fetchAccountDetails(customerId);
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setAccount(account);		
		return customerDetails;
	}
	
	@GetMapping("/message")
	public String message()
	{
		return accountsConfig.getBranchname();
	}
}
