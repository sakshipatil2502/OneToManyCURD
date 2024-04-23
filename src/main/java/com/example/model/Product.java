package com.example.model;

import java.util.Locale.Category;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

public class Product {
	
	//CREATE TABLE PRODUCT(
	//	Product_id INT AUTO_INCREMENT PRIMARY KEY,
    //	Product_name VARCHAR(100) NOT NULL,
	//
	//price DECIMAL(10,2) NOT NULL,
	//	category_id INT,
	//FOREIGN KEY(category_id) REFERENCES CATEGORY(category_id));

	

   
   @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    
   @Column(name="Product_id")
   private Long Product_id;
   
   @Column(name="Product_name")
    private String Product_name;
   
   @Column(name="price")
    private float price;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

	public Long getProduct_id() {
		return Product_id;
	}

	public void setProduct_id(Long product_id) {
		Product_id = product_id;
	}

	public String getProduct_name() {
		return Product_name;
	}

	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product(Long product_id, String product_name, float price, Category category) {
		super();
		Product_id = product_id;
		Product_name = product_name;
		this.price = price;
		this.category = category;
	}
   
    
	public void Product() {
		
	}

	@Override
	public String toString() {
		return "Product [Product_id=" + Product_id + ", Product_name=" + Product_name + ", price=" + price
				+ ", category=" + category + "]";
	}
	
	
    

}
