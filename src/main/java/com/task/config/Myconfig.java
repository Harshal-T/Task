package com.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;



@Configuration
@EnableWebSecurity
public class Myconfig {
	
	@Bean
	public UserDetailsService getUserDetailService()
	{
		return new CustomSholderimpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getUserDetailService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return daoAuthenticationProvider;
	}
	
	//configure method....
	protected void configure(AuthenticationManagerBuilder auth)  throws Exception{
		
//		auth.authenticationProvider(authenticationProvider());
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	protected DefaultSecurityFilterChain configure(HttpSecurity http)  throws Exception{
        http.authorizeHttpRequests((authz) -> authz
        		.requestMatchers("/user/**").hasRole("USER")
          .requestMatchers("/**").permitAll())
        .formLogin(formlogin->formlogin.defaultSuccessUrl("/user/page")).logout(logout->logout.logoutUrl("/dologout"))
        .csrf(csrf -> csrf.disable());
		
		return http.build();
	}

}
