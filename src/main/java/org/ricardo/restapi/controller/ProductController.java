package org.ricardo.restapi.controller;

import java.util.List;

import org.ricardo.restapi.domain.dto.ProducDTO;
import org.ricardo.restapi.domain.model.Product;
import org.ricardo.restapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/products", produces = "application/json")
	public List<Product> getProducts(){
		return productService.getAllProducts();
	}
	
	
	@PostMapping(value = "/products")
	public ResponseEntity saveProduct(@RequestBody ProducDTO productDTO) {
		productService.createProduct(productDTO);
		
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/productId")
	public ResponseEntity updateProduct(@PathVariable int productId, @RequestBody ProducDTO productDTO) {
		productService.updateProduct(productId,productDTO);
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/productId")
	public ResponseEntity deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	
}
