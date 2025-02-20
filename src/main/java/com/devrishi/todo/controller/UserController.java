package com.devrishi.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/getuser/{id}")
	public String addUser(@RequestParam(defaultValue = "Unknown") String name , @RequestParam(defaultValue = "0") int age,@PathVariable int id) {
		return "get user "+name+" age "+ age +" id "+id;
	}
}
