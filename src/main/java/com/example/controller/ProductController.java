package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")

public class ProductController {
	 @Autowired
	    private ProductRepository productRepository;
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
	     productRepository.deleteById(id);
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }

