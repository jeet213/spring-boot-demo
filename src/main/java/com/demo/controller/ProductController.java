package com.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Product;
import com.demo.model.Response;
import com.demo.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/demo/product/v1")
public class ProductController {

	
	
	@Autowired
	private ProductService service;
	
	private enum Code {SUCCESS ,FAIL};
	
	private static Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@ApiOperation(value = "Create New Product", notes = "Create New Product ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created new Product Successfully"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = "/createProduct", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> createProduct(@RequestBody Product prod){
		log.info("create product info>>"+prod);
		Response<Product> resp = new Response<>();
		try {
			resp.setCode(Code.SUCCESS.name());
			resp.setMessage("Data Created Successfully");
			resp.setData(service.createProduct(prod));
			return new ResponseEntity<Response<Product>>(resp, HttpStatus.CREATED);
			
		}catch(Exception e) {
			resp.setCode(Code.FAIL.name());
			resp.setMessage("fail while creating data");
			resp.setData(null);
			return new ResponseEntity<Response<Product>>(resp, HttpStatus.CREATED);
		}
	}
	
	@ApiOperation(value = "To find all the Product", notes = "To find all the Product ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "To Find all the Product"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = "/findAllProduct", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> findAllProduct(){
		Response<List<Product>> resp = new Response<>();
		try {
			resp.setCode(Code.SUCCESS.name());
			resp.setMessage("Get All product");
			resp.setData(service.getAllProduct());
			return new ResponseEntity<Response<List<Product>>>(resp, HttpStatus.FOUND);
			
		}catch(Exception e) {
			resp.setCode(Code.FAIL.name());
			resp.setMessage("fail while fetching data");
			resp.setData(null);
			return new ResponseEntity<Response<List<Product>>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "Find by Product Id ", notes = "find By Product Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "To Find all the Product"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = "/findById", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> findById(@RequestParam String param){
		Response<Product> resp = new Response<>();
		try {
			resp.setCode(Code.SUCCESS.name());
			resp.setMessage("Get by Id product:"+param);
			resp.setData(service.getProductById(param));
			return new ResponseEntity<Response<Product>>(resp, HttpStatus.FOUND);
			
		}catch(Exception e) {
			resp.setCode(Code.FAIL.name());
			resp.setMessage("fail while fetching data:"+param);
			resp.setData(null);
			return new ResponseEntity<Response<Product>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "Delete the Product ", notes = "delete the Product")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Delete the Product"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = "/deleteById", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> deleteById(@RequestParam String param){
		Response<String> resp = new Response<>();
		try {
			service.deleteProduct(param);
			resp.setCode(Code.SUCCESS.name());
			resp.setMessage("Get by Id product:"+param);
			resp.setData("Delete successfully");
			return new ResponseEntity<Response<String>>(resp, HttpStatus.CREATED);
			
		}catch(Exception e) {
			resp.setCode(Code.FAIL.name());
			resp.setMessage("fail while Deleting data:"+param);
			resp.setData(null);
			return new ResponseEntity<Response<String>>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
