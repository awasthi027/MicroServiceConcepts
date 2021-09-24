package com.learning.docker.dockerlearning.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "v1/todo")
@RestController
public class TodoController {

	@GetMapping(path = "/greet")
	public String greeting() {
		return "Hello Namaste!!!";
	}
}
