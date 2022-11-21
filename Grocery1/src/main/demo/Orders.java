package com.example.demo;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
	@SequenceGenerator(name="seq",initialValue = 10000)
	private int orderId;
    @ManyToMany
	private Set<Product> product;
	private int quantity;
    @ManyToMany
	private Set<User> user;
	private int total_cost;
	///
	
	
}
	







