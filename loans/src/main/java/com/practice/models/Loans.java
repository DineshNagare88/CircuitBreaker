package com.practice.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Loans {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loan_number")
	private Integer loanNumber;
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name="start_dt")
	private Date startDt;
	
	@Column(name = "loan_type")
	private String loanType;
	
	@Column(name = "total_loan")
	private Integer totalLoan;
	
	@Column(name = "amount_paid")
	private Integer amountPaid;
	
	@Column(name = "outstanding_amount")
	private Integer outstandingAmount;
	
	@Column(name = "create_dt")
	private String createDt;

}
