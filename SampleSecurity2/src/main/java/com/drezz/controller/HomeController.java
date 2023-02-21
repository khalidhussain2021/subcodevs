package com.drezz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/show")
	public String  home() {
		return  "welcome to Home Dashbaord";
	}
   
	@GetMapping("/admin")
	public String admin() {
		return "Admin page " ;
	}
}
