package com.awasthi027.unittesting.unittesting.controllers;



import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ItemControllerITTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void jsonRequestTest() throws JSONException {
		String respStr = restTemplate.getForObject("/item-bussines-layer", String.class);
	    JSONAssert.assertEquals("[{id:101},{id:102},{id:103}]", respStr, false);
	}
	
}
