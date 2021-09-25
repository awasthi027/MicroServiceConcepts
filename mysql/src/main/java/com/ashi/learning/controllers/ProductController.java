package com.ashi.learning.controllers;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashi.learning.entities.Product;
import com.ashi.learning.repos.ProductRepo;

@RestController
public class ProductController {

	@Autowired
	private ProductRepo productRepo;

	
	@GetMapping(path = "/v1/products/")
	public List<Product> findProducts() {
		return productRepo.findAll();
	}

	@Transactional(readOnly = true)
	@Cacheable("product-cache")
	@GetMapping(path = "/v1/product/{id}")
	public Product findProduct(@PathVariable("id") int id) {
		return productRepo.findById(id).get();
	}

	@PostMapping(path = "/v1/createproduct")
	public Product createProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}

	@PutMapping(path = "/v1/updateproduct/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
		Optional<Product> existingProduct = productRepo.findById(id);
		if (existingProduct.isPresent()) {
			Product availableProduct = existingProduct.get();
			availableProduct.setName(product.getName());
			availableProduct.setDescription(product.getDescription());
			availableProduct.setPrice(product.getPrice());
			return productRepo.save(availableProduct);

		}
		return null;
	}
	
	@CacheEvict("product-cache")
	@DeleteMapping(path = "/v1/deleteproduct/{id}")
	public void deleteProudct(@PathVariable int id) {
		 productRepo.deleteById(id);
	}

}
