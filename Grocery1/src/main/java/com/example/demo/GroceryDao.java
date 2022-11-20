package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroceryDao {

	@Autowired
	LoginRepository loginRepo;

	public Boolean findUserName(String userName) {
		Login login = loginRepo.findById(userName).get();
		if (login.equals(null)) {
			return true;
		}
		return false;
	}

}
