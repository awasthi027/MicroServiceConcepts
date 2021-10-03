package com.ashi.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashi.learning.model.Coupon;
import com.ashi.learning.repos.CouponRepository;

@RestController
@RequestMapping(path = "v1/couponapi")
public class CouponController {
	
	@Autowired
	CouponRepository couponRepository;
	
	@PostMapping(path = "/create")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return couponRepository.save(coupon);
	}
	
	@GetMapping(path = "/coupon/{code}")
	public Coupon coupon(@PathVariable String code) {
		return couponRepository.findByCode(code);
	}

}
