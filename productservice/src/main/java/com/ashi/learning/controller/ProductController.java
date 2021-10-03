package com.ashi.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ashi.learning.dto.Coupon;
import com.ashi.learning.model.Product;
import com.ashi.learning.repos.ProductRepo;

@RestController
@RequestMapping(path = "v1/productapi")
public class ProductController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ProductRepo repo;
	
	@Value("${coupon.service.url}")
	private String couponServiceURL;
	
	@PostMapping(path = "/create")
	public Product createProduct(@RequestBody Product product) {
		Coupon coupon = restTemplate.getForObject(couponServiceURL 
	     + product.getCouponCode(), Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);
	}
	
	@GetMapping(path = "/product")
	public Product product(@PathVariable long id) {
		return repo.findById(id).get();
	}

}
