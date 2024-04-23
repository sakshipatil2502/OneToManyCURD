package com.example.controller;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;

import com.example.model.Caterory;
import com.example.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {

	 @Autowired
	   private CategoryRepository categoryRepository;
	 
	 
	 @PostMapping("/caterory")
	 public String createNewCaterogy(@RequestBody Category category) {
		 categoryRepository.save(category);
		 return "category created in database";
	 }
	 
	 @GetMapping("/caterory")
	 public ResponseEntity<List<Caterory>>getAllCategories(){
		 List<Caterory>catList = new ArrayList<>();
		 catList.forEach(catList::add);
		 return new ResponseEntity<List<Caterory>>(catList,HttpStatus.OK);
	 }
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
	     categoryRepository.deleteById(id);
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	

