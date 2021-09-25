package com.ashi.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.ashi.learning.entities.Product;


@SpringBootTest
class ProductRestTemplateTestCases {

	private static final Logger logger = LoggerFactory.getLogger(ProductRestTemplateTestCases.class);
	@Value("${mysql.services.url}")
	private String baseURL;
	
	@Test
	void createProduct() {
		RestTemplate template = new RestTemplate();
		Product createProduct = new Product();
		createProduct.setName("Motor Bike");
		createProduct.setDescription("Motor bike is great product and having great riding experience.");
		createProduct.setPrice(700000);
		
	   Product newProduct = template.postForObject(baseURL + "createproduct", 
			   createProduct,Product.class);
	   assertNotNull(newProduct);
	   assertNotNull(newProduct.getId());
	   assertEquals("Motor Bike", newProduct.getName());
	}
	
	@Test
	void testGetProduct() {
		logger.info("BaseURL======" + baseURL);
	  RestTemplate template = new RestTemplate();
	  Product product = template.getForObject(baseURL + "product/1", Product.class);
	  assertNotNull(product);
	  assertEquals("Ceiling Fan", product.getName());
		
	}
	
	@Test
	 void updateProduct() {
		RestTemplate template = new RestTemplate();
		Product product = template.getForObject(baseURL + "product/1", Product.class);
		product.setPrice(1000);
		template.put(baseURL + "updateproduct/1", product);
         product = template.getForObject(baseURL + "product/1", Product.class);
         assertEquals(1000, product.getPrice());
		
	}

}
