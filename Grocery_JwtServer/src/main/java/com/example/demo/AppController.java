package com.example.demo;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class AppController {

	@Autowired
	LoginRepository loRepo;

	@GetMapping("validate")
	public ResponseEntity<String> doValidate(HttpServletRequest request) {

		String authToken = request.getHeader("Authorization");

		String token = authToken.substring("Bearer ".length());
		try {
			Algorithm al = Algorithm.HMAC256("onlinegrocery".getBytes());
			JWTVerifier verifier = JWT.require(al).build();
			verifier.verify(token);

			DecodedJWT decode = verifier.verify(token);
			System.out.println("helloooo "+decode.getSubject());
			if(decode.getSubject()==null){
				System.out.println("subject is null");
				return new ResponseEntity("customer", HttpStatus.ACCEPTED);
			}
			

			return new ResponseEntity("admin", HttpStatus.ACCEPTED);
			
			
		
			
		} catch (Exception e) {
			
			
			return new ResponseEntity("false", HttpStatus.BAD_REQUEST);
		}
	
	}

	@PostMapping("authenticate")
	public ResponseEntity doauthenticate( @RequestBody User user) {
		

			Login l = loRepo.findById(user.getUsername()).get();
			if (user.getUsername().equals(l.getUsername()) && user.getPassword().equals(l.getPassword())) {

				String token = JWT.create().withSubject(l.getRole())

						.withIssuedAt(new Date(System.currentTimeMillis()))
						.withExpiresAt(new Date(System.currentTimeMillis() + (1000 * 60 * 10)))
						.sign(Algorithm.HMAC256("onlinegrocery"));

				HttpHeaders headers = new HttpHeaders();
				headers.set("Authorization", "Bearer " + token);
				
				Result rs = new Result();
				rs.setFlag("true");
				rs.setToken(headers.toString());
				
				return new ResponseEntity( rs , HttpStatus.OK);
			} else {
			
			return new ResponseEntity<String>("false", HttpStatus.ACCEPTED);

		}
	}
}
