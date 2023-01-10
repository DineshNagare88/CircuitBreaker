package com.practice.response;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Cards {
	
	private Integer cardId;
	private Integer customerId;
	private String cardNumber;
	private String cardType;
	private Integer totalLimit;
	private Integer amountUsed;
	private Integer availableAmount;
	private Date createDt;
}
