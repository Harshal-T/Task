package com.task.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.task.entities.Stakeholder;
import com.task.repository.StakeholderRepository;

public class CustomSholderimpl implements UserDetailsService {

	@Autowired
	private StakeholderRepository strepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            
		Stakeholder stholder=strepo.getUserByUserName(username);
		
		if(stholder==null)
		{
			throw new UsernameNotFoundException("User not found");
		}
		
        CustomStakeholderDetails customustakeholderdetails=new CustomStakeholderDetails(stholder);
		
		return (UserDetails) customustakeholderdetails;

//		return null;
	}

}
