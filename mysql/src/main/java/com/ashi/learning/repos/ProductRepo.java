package com.ashi.learning.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashi.learning.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
