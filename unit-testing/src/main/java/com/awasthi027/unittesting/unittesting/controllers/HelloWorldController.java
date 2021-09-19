package com.awasthi027.unittesting.unittesting.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path = "/hello-world")
    public String helloWorld() {
    	return "Welcome on Mockito and Junit test cases";
    }

}
