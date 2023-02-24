package com.drezz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping({"/home","/"})
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/hello")
	public String showHello() {
		return "hello";
	}
	
	//ONLY ADMIN After login
	// .antMatchers("/admin").hasAuthority("ADMIN")
	@GetMapping("/admin")
	public String showAdmin() {
		return "admin";
	}
	
	//ONLY CUSTOMER After login
	// .antMatchers("/customer").hasAuthority("CUSTOMER")
	@GetMapping("/customer")
	public String showCustomer() {
		return "customer";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
}
