package com.ashi.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.ashi.learning.entities.Product;

class ProductRestTemplateTestCases {

	@Test
	void testGetProduct() {
		RestTemplate template = new RestTemplate();
	  Product product = template.getForObject("http://localhost:8080/v1/product/1", Product.class);
	  assertNotNull(product);
	  assertEquals("Ceiling Fan", product.getName());
		
	}
	
	@Test
	void createProduct() {
		RestTemplate template = new RestTemplate();
		Product createProduct = new Product();
		createProduct.setName("Motor Bike");
		createProduct.setDescription("Motor bike is great product and having great riding experience.");
		createProduct.setPrice(700000);
		
	   Product newProduct = template.postForObject("http://localhost:8080/v1/createproduct", 
			   createProduct,Product.class);
	   assertNotNull(newProduct);
	   assertNotNull(newProduct.getId());
	   assertEquals("Motor Bike", newProduct.getName());
	}
	
	@Test
	 void updateProduct() {
		RestTemplate template = new RestTemplate();
		Product product = template.getForObject("http://localhost:8080/v1/product/1", Product.class);
		product.setPrice(1000);
		template.put("http://localhost:8080/v1/updateproduct/1", product);
         product = template.getForObject("http://localhost:8080/v1/product/1", Product.class);
         assertEquals(1000, product.getPrice());
		
	}

}
