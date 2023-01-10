package com.practice.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practice.models.Loans;

public interface LoanRepository extends CrudRepository<Loans, Serializable> 
{
	List<Loans> findByCustomerId(int customerId);

}
