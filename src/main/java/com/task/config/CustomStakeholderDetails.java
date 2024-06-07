package com.task.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.task.entities.Stakeholder;

//import com.smart.entities.User;

public class CustomStakeholderDetails implements UserDetails {

private Stakeholder sholder;
	
	

	public CustomStakeholderDetails(Stakeholder sholder) {
		super();
		this.sholder = sholder;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		SimpleGrantedAuthority grantedauthority=new SimpleGrantedAuthority(sholder.getRole());
		
		return List.of(grantedauthority);
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return sholder.getPassword();
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return sholder.getEmail();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
