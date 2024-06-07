package com.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.smart.entities.User;
import com.task.entities.Stakeholder;
import com.task.repository.StakeholderRepository;

@Controller
public class Stakeholdercontroller {
	
	@Autowired
	private StakeholderRepository srepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/signup")
	 public String regstrn()
	 {
		 return "signup";
	 }
	
	@PostMapping("/regstrn")
	public String register(@ModelAttribute("shold") Stakeholder stakeholder)
	{
		System.out.println(stakeholder.getName());
//		System.out.println(stakeholder.getRole());
		
		if(stakeholder.getType().equals("HR"))
		{
			stakeholder.setType("HR");
		}
		else if(stakeholder.getType().equals("Accountant"))
		{
			stakeholder.setType("ACCOUNTANT");
		}
		else if(stakeholder.getType().equals("Sales"))
		{
			stakeholder.setType("SALES");
		}
		else
		{
			stakeholder.setType("ADMINISTRATION");
		}
		
		stakeholder.setRole("ROLE_USER");
		stakeholder.setPassword(passwordEncoder.encode(stakeholder.getPassword()));
		
		this.srepo.save(stakeholder);
		return "signup";
	}
}
