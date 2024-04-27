package com.example.controller;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Caterory;
import com.example.repository.CategoryRepository;




@RestController
@RequestMapping("/api")
public class CategoryController {

	 private static final Category Caterory = null;
	@Autowired
	   private static CategoryRepository categoryRepository;
	 
	 
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
	 
	 @GetMapping("/categories/{id}") // Define the endpoint with a path variable for the category ID
	 public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
	     Optional<Category> categoryOptional = categoryRepository.findById(id);
	     if (categoryOptional.isPresent()) {
	         return ResponseEntity.ok(categoryOptional.get()); // Return 200 OK with the category if found
	     } else {
	         return ResponseEntity.notFound().build(); // Return 404 NOT_FOUND if category is not found
	     }
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
	     categoryRepository.deleteById(id);
	     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 
	 
	 
	 @PutMapping("/{id}")
	 public static ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category updatedCategory) {
	     Optional<Category> categoryOptional = categoryRepository.findById(id);
	     if (categoryOptional.isPresent()) {
	    	 Long Long;
			HttpEntity<Category> caterory;
			try {
				caterory = com.example.controller.CategoryController.updateCategory(Long, Caterory);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         Category category1 = categoryOptional.get();
	         if(updatedCategory != null){
	        	 
			caterory.setName(updatedCategory.name());
	         }
	         Category savedCategory = categoryRepository.save(category1);
	         return new ResponseEntity<>(savedCategory, HttpStatus.OK);
	     } else {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 }
	 
	
	}
		

