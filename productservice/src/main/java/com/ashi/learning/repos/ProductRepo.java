package com.ashi.learning.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashi.learning.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
