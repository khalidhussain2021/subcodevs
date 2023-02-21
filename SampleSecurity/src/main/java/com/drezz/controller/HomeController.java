package com.drezz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/user")
	public String home() {
		return "Welcome to Home";
	}
   
	 @GetMapping("/admin")
	 public String admin() {
		 return "Welcome to admin";
	 }
 }
