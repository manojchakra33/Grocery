package com.example.demo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class User {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int userId;
	private String name;
	private int mobileNumer;
	private String address;
	@OneToOne
	@JoinColumn(name="userName")
	private Login login;

	
}
