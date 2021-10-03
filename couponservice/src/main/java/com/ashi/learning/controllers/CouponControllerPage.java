package com.ashi.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ashi.learning.model.Coupon;
import com.ashi.learning.repos.CouponRepository;


@Controller
public class CouponControllerPage {
	
	@Autowired
	private CouponRepository repository;
	
   @RequestMapping(path = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
   
   @RequestMapping(path = "/showCreateCoupon", method = RequestMethod.GET)
 	public String showCreateCoupon() {
 		return "createcoupon";
 	}
   
   @PostMapping(path = "/saveCoupon")
   public String save(Coupon coupon) {
	   repository.save(coupon);
	   return "couponcreated";
   }
   
   @RequestMapping(path = "/showGetCoupon", method = RequestMethod.GET)
   public String showGetCoupon() {
	   return "getcoupon";
   }
   
   @PostMapping("/getCoupon")
   public ModelAndView getCoupon(String code) {
	   ModelAndView modelAndView = new ModelAndView("coupondetails");
	   modelAndView.addObject(repository.findByCode(code));
	   return modelAndView;
   }

}
