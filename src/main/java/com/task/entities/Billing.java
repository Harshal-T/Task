package com.task.entities;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

//import java.util.Date;
import java.sql.Date;


@Entity
public class Billing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bid;
	private String amount;
	private String payee; //jisko bill milega
    private String drawee; //jisko bill bharna hai
    private LocalDate issue_date;
    
    
	public Billing(String amount, String payee, String drawee, LocalDate issue_date) {
		super();
		
		this.amount = amount;
		this.payee = payee;
		this.drawee = drawee;
		this.issue_date = issue_date;
	}


	public Billing() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getPayee() {
		return payee;
	}


	public void setPayee(String payee) {
		this.payee = payee;
	}


	public String getDrawee() {
		return drawee;
	}


	public void setDrawee(String drawee) {
		this.drawee = drawee;
	}


	public LocalDate getIssue_date() {
		return issue_date;
	}


	public void setIssue_date(LocalDate issue_date) {
		this.issue_date = issue_date;
	}
	
	
    
    
}
