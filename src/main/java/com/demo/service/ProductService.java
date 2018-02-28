package com.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Product;
import com.demo.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	private static Logger log = LoggerFactory.getLogger(ProductService.class);

	public Product createProduct(Product prod) throws Exception {
		log.info(" Create Product>>" + prod);
		return productRepo.save(prod);

	}

	public List<Product> getAllProduct() throws Exception {
		return productRepo.findAll();
	}

	public Product getProductById(String id) throws Exception {
		log.info("Id is>> " + id);
		return productRepo.findOne(id);
	}

	public void deleteProduct(String param) throws Exception {
		log.info("delete product >>" + param);
		productRepo.delete(productRepo.findOne(param));
	}
}
