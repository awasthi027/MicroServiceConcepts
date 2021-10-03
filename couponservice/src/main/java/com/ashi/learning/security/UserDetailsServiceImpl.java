package com.ashi.learning.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ashi.learning.model.User;
import com.ashi.learning.repos.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
   
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found for email" + username);
		}
		System.out.println("=====================" + user.toString());
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), (Collection<? extends GrantedAuthority>) user.getRoles());
	}

}
