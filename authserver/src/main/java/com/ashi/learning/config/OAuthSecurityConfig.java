package com.ashi.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class OAuthSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
    	
    	return super.authenticationManagerBean();
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
