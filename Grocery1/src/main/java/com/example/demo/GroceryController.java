package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.Order;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
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

	// 1.Register new User
	@PostMapping("regUser")
	public ResponseEntity<String> regUser(@RequestBody User user) {

		Login login = user.getLogin();
		Boolean flag = groceryDao.findUserId(login.getUserName());
		Boolean flag1=groceryDao.checkMobileNum(user.getMobileNumber());
		if (flag==true && flag1==true) {
			
			loginRepo.save(login);
			userRepo.save(user);
			return new ResponseEntity("true", HttpStatus.OK);			
		}
		return new ResponseEntity("false", HttpStatus.OK);
	}

    //2.Register Product Category
	@GetMapping("regCategory/{category}")
	public ResponseEntity regCategory(@PathVariable String category) {
		Category c = groceryDao.setCategory(category);
		return new ResponseEntity(true, HttpStatus.OK);
	}

	//3.Register new Product By Admin
	@PutMapping("regProduct/{category}")
	public ResponseEntity regProduct(@RequestBody Product product, @PathVariable String category) {
		Category c = groceryDao.findCategory(category);
		if (c != null) {
			Set<Category> set = new HashSet<Category>();
			set.add(c);
			product.setCategory(set);
			productRepo.save(product);
			return new ResponseEntity("success", HttpStatus.OK);
		}else
		return new ResponseEntity("category not found", HttpStatus.OK);
	}

	//4.Place order
	@PostMapping("placeOrder")
	public ResponseEntity placeOrder(@RequestBody Orders orders) {
		Orders orderFinal = new Orders();

		List<Product> product = orders.getProduct();
		List<Product> productFinal = new ArrayList<>();
		for (Product p : product) {
			Product pr = productRepo.findById(p.getProductId()).get();
			productFinal.add(pr);
		}
		User user = orders.getUser();
		User userFinal = userRepo.findById(user.getUserId()).get();

		orderFinal.setProduct(productFinal);
		orderFinal.setUser(userFinal);

		Orders o = ordersRepo.save(orderFinal);
		return new ResponseEntity(o, HttpStatus.OK);
	}

	//5.List all products
	@GetMapping("findAllproducts")
	public List<Product> getProducts() {
		return productRepo.findAll();
	}

	//6.List products by category
	@GetMapping("findByCategory/{category}")
	public List<Product> getProductsByCategory(@PathVariable String category) {
		Category c = groceryDao.findCategory(category);
		return productRepo.findAllBycategory(c);
	}

	//7.Delete category by name
	@DeleteMapping("delCategory/{CategoryName}")
	public Category deleteByCategory(@PathVariable String CategoryName) {
		Category c = groceryDao.deleteCategory(CategoryName);
		return c;

	}

	//8.Update user details and Change Password
	@PostMapping("updateUser")
	public User updateUser(@RequestBody User user) {
		loginRepo.save(user.getLogin());
		return userRepo.save(user);
	}

	//9.update category by Admin
	@PostMapping("updateCategory")
	public Category deleteCategory(@RequestBody Category category) {
		return categoryRepo.save(category);
	}
	
	//10.update products by Admin
	@PostMapping("updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}
	
	//11.delete product by admin
	@DeleteMapping("delProduct/{id}")
	public String delProduct(@PathVariable int id) {
	  	productRepo.deleteById(id);
	  	return "success";
		
	}
	
	//12.List all Orders
	@GetMapping("listAll")
		public List<Orders> listAll() {
			List<Orders> product= ordersRepo.findAll();
			return product;		
	}
	
	//13.list all category
	@GetMapping("listCategory")
	public List<Category> listCategory(){
		return categoryRepo.findAll();
	}
	

	//14.Show order by userName
	@GetMapping("orderByUser/{userName}")
	public List<Orders> showAllbyUserId(@PathVariable String userName){
		return groceryDao.findOrders(userName);		
	}
	
	//15.Top selling product                     
	@GetMapping("topSell")
	public List<TopSold> topSellingProducts(){		
		return groceryDao.topSell();	   
		
	}
	
	
	
	
}