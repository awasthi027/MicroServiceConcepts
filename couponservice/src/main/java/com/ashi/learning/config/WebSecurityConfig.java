package com.ashi.learning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ashi.learning.security.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsServiceImpl userDetailsimpl;
	
     @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsimpl);
    }
     
     @Override
    protected void configure(HttpSecurity http) throws Exception {
       
       http.authorizeRequests().mvcMatchers(HttpMethod.GET,"v1/couponapi/coupon/{code:[A-Z*$]}","/index",
    		   "coupondetails","getcoupon","coupondetails").hasAnyRole("USER")
       .mvcMatchers(HttpMethod.GET,"/createcoupon",
    		   "getcoupon","couponcreated").hasAnyRole("ADMIN")
       .mvcMatchers(HttpMethod.GET,
    		   "getcoupon","registration").hasRole("USER")
       .mvcMatchers("/login").permitAll()
       .mvcMatchers(HttpMethod.POST, "v1/couponapi/create/").hasRole("ADMIN").and().csrf().disable().logout().logoutSuccessUrl("/login").invalidateHttpSession(true);
    }

   @Bean
    public PasswordEncoder passwordEncoder() {
    	 return new BCryptPasswordEncoder();
    }
     
   @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
    	return super.authenticationManagerBean();
    }

}
