package com.example.demo;

import java.net.InetAddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GroceryGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryGatewayApplication.class, args);
	}

	@Bean
	public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) {
	EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
	String ip = null;
	try {
	ip = InetAddress.getLocalHost().getHostAddress();
	} catch (Exception e) {
	System.out.println("Exception");
	}
	config.setNonSecurePort(8087);
	config.setIpAddress(ip);
	config.setPreferIpAddress(true);
	return config;
	}
	
	
	@Bean
	public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
	return builder.routes()
	.route(t->t.path("/validate/").uri("lb://grocery_jwtserver"))
	.route(t->t.path("/authenticate/").uri("lb://grocery_jwtserver"))

	.route(t->t.path("/regUser/").uri("lb://grocery"))
	.route(t->t.path("/regCategory/*").uri("lb://grocery"))
	.route(t->t.path("/regProduct/*").uri("lb://grocery"))
	.route(t->t.path("/placeOrder/").uri("lb://grocery"))
	.route(t->t.path("/findAllproducts/").uri("lb://grocery"))
	.route(t->t.path("/findByCategory/*").uri("lb://grocery"))
	.route(t->t.path("/delCategory/*").uri("lb://grocery"))
	.route(t->t.path("/updateUser/").uri("lb://grocery"))
	.route(t->t.path("/updateCategory/").uri("lb://grocery"))
	.route(t->t.path("/updateProduct/").uri("lb://grocery"))
	.route(t->t.path("/delProduct/*").uri("lb://grocery"))
	.route(t->t.path("/listAll/").uri("lb://grocery"))
	.route(t->t.path("/listCategory/").uri("lb://grocery"))
	.route(t->t.path("/orderByUser/*").uri("lb://grocery"))
	.route(t->t.path("/topSell/").uri("lb://grocery"))
	.route(t->t.path("/cancelOrder/*").uri("lb://grocery"))
	.route(t->t.path("/getProductsByName/*").uri("lb://grocery"))
	.route(t->t.path("/delProductFromOrder/**").uri("lb://grocery"))
	.route(t->t.path("/updateAddress/*").uri("lb://grocery"))
	.route(t->t.path("/addToCart/**").uri("lb://grocery"))
	.route(t->t.path("/getCartByUserName/*").uri("lb://grocery"))
//	.route(t->t.path("/updateAddress/*").uri("lb://grocery"))
//	.route(t->t.path("/saveorder/**").uri("lb://grocery"))
	.build();
	}
	
}
