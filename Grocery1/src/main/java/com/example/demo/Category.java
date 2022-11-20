package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Category {
	@Id
	private int categoryId;
	private String categoryName;
	

}
