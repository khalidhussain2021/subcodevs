//package com.drezz.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.drezz.dto.Product;
//import com.drezz.service.ProductService;
//
//@RestController
//@RequestMapping("/products")
//public class ProductController {
//	
//	@Autowired
//	private ProductService service;
//	
//	@GetMapping("/welcome")
//	public String home() {
//		return "Welcome to Home";
//	}
//	
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
//	@GetMapping("/all")
//	public List<Product> getAllproduct() {
//		return service.getProducts();
//		
//	}
//	
//	@PreAuthorize("hasAuthority('ROLE_USER')")
//	@GetMapping("/{id}")
//	public Product getProductById(@PathVariable int id) {
//		return service.getProduct(id); 
//	}
//	
//	@GetMapping("/login")
//	public String showLogin() {
//		return "login";
//	}
//
//}
