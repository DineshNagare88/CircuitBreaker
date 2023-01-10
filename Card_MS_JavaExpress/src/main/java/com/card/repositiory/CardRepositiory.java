package com.card.repositiory;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.card.entity.Cards;

@Repository
public interface CardRepositiory extends CrudRepository<Cards, Serializable>{
	
	List<Cards> findByCustomerId(Integer customerId);
}
