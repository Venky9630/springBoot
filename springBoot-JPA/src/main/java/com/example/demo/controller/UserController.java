package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserDetails;
import com.example.demo.service.UserService;

@RestController

public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public void addUser(@RequestBody UserDetails userDetails) {
		userService.addUser(userDetails);
	}
	
	@GetMapping(value="/user/{id}")
	public Optional<UserDetails> getUser(@PathVariable String id){
		
		return userService.getUser(id);
		
	}
	
	@GetMapping("/fetch")
	public List<UserDetails> getAll(){
		return userService.getAllUsers();
		
	}
	@RequestMapping(value="/delet/{id}", method = RequestMethod.GET)
	public void deletById(@PathVariable("id") int id){
	 userService.deletUser(id);
	}

}
