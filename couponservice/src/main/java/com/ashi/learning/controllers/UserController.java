package com.ashi.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashi.learning.model.User;
import com.ashi.learning.repos.UserRepository;
import com.ashi.learning.security.SecurityService;

@Controller
public class UserController {
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping(path = "/login")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping(path = "/login")
	public String loginWith(String email, String password) {
		Boolean loginResponse = securityService.login(email, password);
		if (loginResponse) {
			return "index";
		}
		return "login";
	}
	
	@GetMapping(path = "/showregistration")
	public String showRegistration() {
		return "registration";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login";
	}
}
