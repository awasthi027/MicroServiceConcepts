package com.ashi.learning.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashi.learning.models.Person;

@RestController
@RequestMapping(path = "api/v1")

public class TestController {
	
	@Autowired
	RabbitTemplate reRabbitTemplate;
	
	@GetMapping(path = "/test/{name}")
	public String testAPI(@PathVariable("name") String name) {
		
		Person person = new Person(1L, name);
		reRabbitTemplate.convertAndSend("mobile",person);
		reRabbitTemplate.convertAndSend("direct-exchange","mobilekey",person);
		reRabbitTemplate.convertAndSend("fanout-exchange","",person);
		reRabbitTemplate.convertAndSend("topic-exchange","tv.mobilekey.ac",person);
		return "Success";
	}
	@GetMapping(path = "/testheader/{name}")
	public String testHeader(@PathVariable("name") String name) throws IOException {
		
		Person person = new Person(1L, name);
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    ObjectOutput output = new ObjectOutputStream(bos);
	    output.writeObject(person);
	    output.flush();
	    output.close();
	    
	    byte [] byteMessage = bos.toByteArray();
	    bos.close();
	    
	    Message  message = MessageBuilder.withBody(byteMessage)
	    		.setHeader("item1", "mobile")
	    		.setHeader("item2", "tv").build();
	    
	    bos.close();
		
		reRabbitTemplate.convertAndSend("header-exchange","",message);
		
		return "Success";
	}

}
