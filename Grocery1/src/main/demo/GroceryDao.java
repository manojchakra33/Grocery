package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroceryDao {

	@Autowired
	LoginRepository loginRepo;

	@Autowired
	CategoryRepository categoryRepo;

	public Boolean findUserId(String userName) {

		List<Login> login = loginRepo.findAll();
		for (Login l : login) {
			if (l.getUserName().equals(userName)) {
				return false;
			}
			return true;
		}
		return true;
	}
	
	public Category setCategory(String catrgory) {
		Category c=new Category();
		c.setCategoryName(catrgory);
		return categoryRepo.save(c);
	}
	
	public Category findCategory(String name) {
		return categoryRepo.findByCategoryName(name);
		
	
	}
	public Category deleteCategory(String name) {
		Category c=categoryRepo.findByCategoryName(name);
	    categoryRepo.deleteById(c.getCategoryId());
		return c;
	   
	}
	public List<Orders> findOrders(String userName) {
		Login l = loginRepo.findById(userName).get();
		User u = userRepo.findBylogin(l);

		List<Orders> orders = ordersRepo.findByUser(u);
		return orders;

}
