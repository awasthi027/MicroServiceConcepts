package com.learning.security.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.learning.security.security.constants.ServiceConstant;

//@RequestMapping(path = ServiceConstant.API_VERSION)
@RestController
public class NoticeController {
	
	
	@GetMapping(path = ServiceConstant.NOTICE_END_POINT)
	public String requestNotice(String input) {
		return "Hey we don't have any notice on your name";
	}
	@GetMapping(path = ServiceConstant.MYACCOUNT_END_POINT)
	public String requestMyAccount(String input) {
		return "Hey we don't have account associated with this user";
	}
	@GetMapping(path = ServiceConstant.MYBALANCE_END_POINT)
	public String requestAccountBalance(String input) {
		return "Hey we don't have account for banlance";
	}
	@GetMapping(path = ServiceConstant.MYCONTACTS_END_POINT)
	public String requestForConstants(String input) {
		return "Hey we don't have contacts";
	}
	@GetMapping(path = ServiceConstant.MYLOAN_END_POINT)
	public String requestForMyLoan(String input) {
		return "Hey we don't have account for balance";
	}
	@GetMapping(path = ServiceConstant.MYCRAD_END_POINT)
	public String requestForMyCards(String input) {
		return "Hey we don't have account for balance";
	}

}
