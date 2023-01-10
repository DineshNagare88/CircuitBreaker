package com.practice.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Serializable> 
{
   Optional<Account> findByCustomerId(int customerId);
}
