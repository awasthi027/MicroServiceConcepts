package com.learning.security.security.config;


import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.learning.security.security.constants.ServiceConstant;

@EnableWebSecurity
@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
 
	/**
	 * MyAccount 
	 * MyBalance 
	 * MyLoans 
	 * Mycards 
	 * Notices Not secured 
	 * Contacts Not secured 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests((requests) -> requests
				.antMatchers(ServiceConstant.MYACCOUNT_END_POINT).authenticated()
				.antMatchers(ServiceConstant.MYBALANCE_END_POINT).authenticated()
				.antMatchers(ServiceConstant.MYLOAN_END_POINT).authenticated()
				.antMatchers(ServiceConstant.MYBALANCE_END_POINT).authenticated()
				.antMatchers(ServiceConstant.MYLOAN_END_POINT).authenticated()
				);
		http.formLogin();
		http.httpBasic();
		//http.authorizeRequests().antMatchers(ServiceConstant.MYACCOUNT_END_POINT).authenticated().and().formLogin().and().httpBasic();
	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    	 
    	  
    }

}
