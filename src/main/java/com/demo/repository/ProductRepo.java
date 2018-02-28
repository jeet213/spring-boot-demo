package com.demo.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.model.Product;

public interface ProductRepo extends MongoRepository<Product, Serializable> {

	
}
