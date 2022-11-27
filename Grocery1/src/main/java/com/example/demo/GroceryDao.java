package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroceryDao {

	@Autowired
	LoginRepository loginRepo;

	@Autowired
	CategoryRepository categoryRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	OrdersRepository ordersRepo;

	@Autowired
	ProductRepository productRepo;

	public Boolean findUserId(String userName) {

		List<Login> login = loginRepo.findAll();
		for (Login l : login) {
			if (l.getUserName().equals(userName)) {
				return false;
			}

		}
		return true;
	}

	public Category setCategory(String catrgory) {
		Category c = new Category();
		c.setCategoryName(catrgory);
		return categoryRepo.save(c);
	}

	public Category findCategory(String name) {
		return categoryRepo.findByCategoryName(name);

	}

	public Category deleteCategory(String name) {
		Category c = categoryRepo.findByCategoryName(name);
		categoryRepo.deleteById(c.getCategoryId());
		return c;
	}

	public Boolean checkMobileNum(Long number) {
		List<User> user = userRepo.findAll();
		for (User u : user) {
			if (u.getMobileNumber().equals(number)) {
				return false;
			}
		}
		return true;

	}
      
	
	//in progress
	public List<TopSold> topSell() {
		List<Orders> orders = ordersRepo.findAll();
		List<Product> soldProducts = new ArrayList<>();
		List<TopSold> set = new ArrayList<>();// unordered
		List<TopSold> setLast = new ArrayList<>();// ordered

		for (Orders o : orders) {
			List<Product> product = o.getProduct();
			for (Product p : product) {
				soldProducts.add(p);
			}
		}

		for (Product s : soldProducts) {
			TopSold t2 = new TopSold();
			t2.setProductId(s.getProductId());
			t2.setProductName(s.getProductName());
			t2.setTotalSold(s.getCost());
			set.add(t2);
		}

		for (TopSold ts : set) {
			if (setLast.isEmpty()) {
				setLast.add(ts);
			} else {
				for (TopSold tsl : setLast) {
					int id = tsl.getProductId();
					if (ts.equals(id)) {
						TopSold tss = ts;
						tss.setTotalSold(tss.getTotalSold() + ts.getTotalSold());
						tsl.setTotalSold(tss.getTotalSold());

					} else {
						setLast.add(ts);
					}
				}
			}
		}

		return setLast;
	}

	public List<Orders> findOrders(String userName) {
		Login l = loginRepo.findById(userName).get();
		User u = userRepo.findBylogin(l);

		List<Orders> orders = ordersRepo.findByUser(u);
		return orders;

	}

}
