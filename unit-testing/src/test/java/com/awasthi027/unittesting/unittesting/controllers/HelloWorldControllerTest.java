package com.awasthi027.unittesting.unittesting.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloworld_basic() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/hello-world");
				;
		MvcResult mvcResult = mockMvc.perform(requestBuilder)
				.andExpect(status().isOk())
				.andReturn();
		assertEquals("Welcome on Mockito and Junit test cases", mvcResult.getResponse().getContentAsString());
	}

}
