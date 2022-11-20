package com.example.demo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroceryController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	LoginRepository loginRepo;

	@Autowired
	CategoryRepository categoryRepo;

	@Autowired
	ProductRepository productRepo;

	@Autowired
	OrdersRepository ordersRepo;

	@Autowired
	GroceryDao groceryDao;

	@PutMapping("regUser")
	public ResponseEntity regUser(@RequestBody User user, @RequestBody Login login) {
		User user1 = new User();
		user1.setLogin(login);
		user1.setName(user.getName());
		user1.setMobileNumer(user.getMobileNumer());
		user1.setAddress(user.getAddress());
		Boolean flag = groceryDao.findUserName(login.getUserName());
		if(flag) {
		loginRepo.save(login);
		userRepo.save(user1);
		return new ResponseEntity(user1, HttpStatus.OK);
		}else {
			return new ResponseEntity("username already taken", HttpStatus.OK);
		}
		
	}

	@PutMapping("regCategory")
	public ResponseEntity regCategory(@RequestBody Category category) {
		categoryRepo.save(category);
		return new ResponseEntity(category, HttpStatus.OK);
	}

	@PutMapping("regProduct")
	public ResponseEntity regProduct(@RequestBody Product product) {
		Set<Category> set = product.getCategory();// for future operations

		productRepo.save(product);
		return new ResponseEntity(product, HttpStatus.OK);
	}

	@PostMapping("placeOrder")
	public ResponseEntity placeOrder(@RequestBody Orders orders) throws Exception {
		Orders o = ordersRepo.save(orders);

		return new ResponseEntity(o, HttpStatus.OK);
	}

}
