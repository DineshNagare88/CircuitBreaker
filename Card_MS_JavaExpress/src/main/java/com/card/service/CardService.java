package com.card.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.card.controller.CardController;
import com.card.entity.Cards;
import com.card.repositiory.CardRepositiory;

@Service
public class CardService {
	
	private static final Logger logger = LoggerFactory.getLogger(CardController.class);
	@Autowired
	private CardRepositiory cardRepositiory;
	
	/*
	 * public Optional<Cards> getAllCardDetails(Customer customer){
	 * logger.info("getAllCardDetails() method started in cards Microservice");
	 * return cardRepositiory.findByCustomerId(customer.getCustomerId());
	 * 
	 * }
	 */
	
	public List<Cards> getAllCardDetails(int customerId){
	List<Cards> findByCustomerId = cardRepositiory.findByCustomerId(customerId);
	return findByCustomerId;
	}
}
