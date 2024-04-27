package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.repository.ProductRepository;
import com.example.model.Product;
//https://github.com/sakshipatil2502/CURDApi.git
@RestController
@RequestMapping("/api/products")

public class ProductController {
	 @Autowired
	    private ProductRepository productRepository;
	 
	 @PostMapping
	 public ResponseEntity<Product> createProduct(@RequestBody Product product) {
	     Product savedProduct = productRepository.save(product);
	     return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	 }
	 
	 @GetMapping
	 public ResponseEntity<List<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page,
	                                                      @RequestParam(defaultValue = "10") int size) {
	     PageRequest pageable = PageRequest.of(page, size);
	     Page<Product> productPage = productRepository.findAll(pageable);
	     List<Product> products = productPage.getContent();
	     return new ResponseEntity<>(products, HttpStatus.OK);
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
	     Optional<Product> productOptional = productRepository.findById(id);
	     return productOptional.map(product -> new ResponseEntity<>(product, HttpStatus.OK))
	                           .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product updatedProduct) {
	     Optional<Product> productOptional = productRepository.findById(id);
	     if (productOptional.isPresent()) {
	         Product product = productOptional.get();
	         product.setName(updatedProduct.getName());
	         // Set other fields as needed
	         Product savedProduct = productRepository.save(product);
	         return new ResponseEntity<>(savedProduct, HttpStatus.OK);
	     } else {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
	     productRepository.deleteById(id);
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }

