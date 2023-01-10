package com.practice.response;

import java.util.List;

import com.practice.model.Account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CustomerDetails 
{
	private Account account;
	private List<Cards> cards;
	

}
