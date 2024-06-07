package com.task.controllers;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.task.entities.Billing;
import com.task.entities.*;
import com.task.entities.Payroll;
import com.task.entities.Stakeholder;
import com.task.repository.BillingRepo;
import com.task.repository.CustomerRepository;
import com.task.repository.PayrollRepo;
import com.task.repository.StakeholderRepository;
import com.task.repository.UserRepo;

import java.util.*;

@Controller
@RequestMapping("/user")
public class GeneralController {

	@Autowired
	private StakeholderRepository strepo;
	
	@Autowired
	private CustomerRepository ctrepo;
	
	@Autowired
	private BillingRepo billrepo;
	
	@Autowired
	private PayrollRepo plrepo;
	
	@Autowired
	private UserRepo userep;;
	
	@RequestMapping("/page")
	public String first(Principal principal,Model m)
	{
		String name=principal.getName();
		Stakeholder st=strepo.getUserByUserName(name);
		System.out.println(st.getEmail());
		System.out.println("type"+ st.getType());
		m.addAttribute("stholder",st);
		return"normal/homepage";
	}
	
	@RequestMapping("/addcustomer")
	public String customerm()
	{
		return "normal/addcustomer";
	}
	
	@PostMapping("/addthecustomer")
	public String addcustomer(@ModelAttribute("customer") Customer customer)
	{
		this.ctrepo.save(customer);
		
		return "redirect:/user/page";
	}
	
	@RequestMapping("/viewcustomers")
	public String viewCustomers(Principal principal,Model m)
	{
		String name=principal.getName();
		Stakeholder st=strepo.getUserByUserName(name);
		System.out.println("type"+ st.getType());
		List<Customer>customers=this.ctrepo.getAllcutomers();
		System.out.println("No. of cutomers are " +customers.size());
		m.addAttribute("customers",customers);
		return "normal/customers";
	}
	
	@RequestMapping("/viewbills")
	public String viewbills(Principal principal,Model m)
	{
		String name=principal.getName();
		Stakeholder st=strepo.getUserByUserName(name);
		System.out.println("type"+ st.getType());
		List<Billing>bills=this.billrepo.findAll();;
		System.out.println("No. of bills are " +bills.size());
		m.addAttribute("st",st);
		m.addAttribute("bills",bills);
		return "normal/billing";
	}
	
	
	
	@RequestMapping("/bill")
	public String billm()
	{
		return "normal/addbill";
	}
	
	@PostMapping("/addthebill")
	public String addbill(@ModelAttribute("bill") Billing bill)
	{
		LocalDate  todays_date=LocalDate.now();
		bill.setIssue_date(todays_date);		
		this.billrepo.save(bill);
		return "redirect:/user/page";
	}
	
	@RequestMapping("/payroll")
	public String patrolls()
	{
		return "normal/addpayroll";
	}
	
	@PostMapping("/addthepayroll")
	public String addpayrolls(@ModelAttribute("payroll") Payroll payroll)
	{
		this.plrepo.save(payroll);
		return "redirect:/user/page";
	}
	
	@RequestMapping("/viewpayrolls")
	public String viewpayrollss(Principal principal,Model m)
	{
		String name=principal.getName();
		Stakeholder st=strepo.getUserByUserName(name);
		List<Payroll>payrolls=this.plrepo.findAll();
		System.out.println("No. of payrolls are " +payrolls.size());
		m.addAttribute("st",st);
		m.addAttribute("payrolls",payrolls);
		return "normal/payrolls";
		
	}
	
	
	@RequestMapping("/usermanage")
	public String usermanage()
	{
		return "normal/adduser";
	}
	
	@PostMapping("/addtheuser")
	public String addusers(@ModelAttribute("user") User user)
	{
		this.userep.save(user);
		return "redirect:/user/page";
	}
	
	@RequestMapping("/viewusers")
	public String viewpuser(Principal principal,Model m)
	{
		String name=principal.getName();
		Stakeholder st=strepo.getUserByUserName(name);
		List<User>users=this.userep.findAll();
		System.out.println("No. of users are " +users.size());
		m.addAttribute("st",st);
		m.addAttribute("user",users);
		return "normal/userboard";
	}
	
	
	
	//delete the user
	@GetMapping("/delete/{uid}")
	public String deleteuser(@PathVariable("uid") Integer uid)
	{
		Optional<User>user=this.userep.findById(uid);
		User u=user.get();
		userep.delete(u);
		return "redirect:/user/viewusers";
	}
	
	//delete the customer
	@GetMapping("/deletecustomer/{cid}")
	public String deletecustomer(@PathVariable("cid") Integer cid)
	{
		Optional<Customer>customer=this.ctrepo.findById(cid);
		Customer c=customer.get();
		ctrepo.delete(c);
		return "redirect:/user/viewcustomers";
	}
	
	//delete the payroll
	@GetMapping("/deletepayrolls/{pid}")
	public String deletepayroll(@PathVariable("pid") Integer pid)
	{
		Optional<Payroll>payroll=this.plrepo.findById(pid);
		Payroll p=payroll.get();
		plrepo.delete(p);
		return "redirect:/user/viewpayrolls";
	}
	
	//delete bills
	@GetMapping("/deletebills/{bid}")
	public String deletebills(@PathVariable("bid") Integer bid)
	{
		Optional<Billing>bill=this.billrepo.findById(bid);
		Billing b=bill.get();
		billrepo.delete(b);
		return "redirect:/user/viewbills";
	}
}
