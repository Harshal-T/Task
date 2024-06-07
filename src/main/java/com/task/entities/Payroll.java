package com.task.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payroll {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	private String employee_name;
	private String tax;
	private String netpay;
	private String deduction;
	
	public Payroll(String employee_name, String tax, String netpay, String deduction) {
		super();
		
		this.employee_name = employee_name;
		this.tax = tax;
		this.netpay = netpay;
		this.deduction = deduction;
	}

	public Payroll() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getNetpay() {
		return netpay;
	}

	public void setNetpay(String netpay) {
		this.netpay = netpay;
	}

	public String getDeduction() {
		return deduction;
	}

	public void setDeduction(String deduction) {
		this.deduction = deduction;
	}
	
	
	
	

}
