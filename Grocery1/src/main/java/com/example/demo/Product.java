package com.example.demo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	private int productId;
	private String ProductName;
	private int cost;
	private int discount;
    @ManyToMany
	private Set<Category> category;
	private String description;
	private int rating;
	private String image;
	
}
	