package com.example.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="CATEGORY")
public class Caterory {
	//CREATE TABLE CATEGORY(
	//		category_id Int AUTO_INCREMENT PRIMARY KEY,
	//		caterory_name VARCHAR(100) NOT NULL);
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="category_id")
   private Long category_id;
    
	@Column(name="caterory_name")
   private String caterory_name;
	
	@OneToMany(mappedBy="CATEGORY",cascade=CascadeType.ALL)
	
	private List<Product>products=new ArrayList<>();

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public String getCaterory_name() {
		return caterory_name;
	}

	public void setCaterory_name(String caterory_name) {
		this.caterory_name = caterory_name;
	}

	public Caterory(Long category_id, String caterory_name) {
		super();
		this.category_id = category_id;
		this.caterory_name = caterory_name;
	}

	public void CATEGORY(){
		
	}

	@Override
	public String toString() {
		return "Caterory [category_id=" + category_id + ", caterory_name=" + caterory_name + "]";
	}
 
}
