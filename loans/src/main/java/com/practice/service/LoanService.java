package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.models.Loans;
import com.practice.repository.LoanRepository;

@Service
public class LoanService 
{
   @Autowired
   private LoanRepository loanRepository;
	
	public List<Loans> getAllLoansDetails(int customerId) 
	{
		
		return loanRepository.findByCustomerId(customerId);
	}

}
