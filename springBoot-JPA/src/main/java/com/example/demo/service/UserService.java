package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.model.UserDetails;

@Service
@Component
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public void addUser(UserDetails userDetails) {
		userRepository.save(userDetails);
	}

	public Optional<UserDetails> getUser(String id) {
		int n = Integer.parseInt(id);
		return userRepository.findById(n);
	}

	public List<UserDetails> getAllUsers() {
		// TODO Auto-generated method stub
		List<UserDetails> userDetail = new ArrayList<>();
		 userRepository.findAll().forEach(userDetail::add);
		 return userDetail;
	}

	public void deletUser(int id) {
		userRepository.delete(id);
	}

}
