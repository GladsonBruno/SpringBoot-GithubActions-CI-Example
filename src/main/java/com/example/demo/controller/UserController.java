package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;
import com.example.demo.vo.UserVO;

@RestController
public class UserController {

	UserRepository userRepository = new UserRepository();
	
	@GetMapping(path = "/users")
	public ResponseEntity<List<UserVO>> getAll() {
		
		List<UserVO> users = this.userRepository.getAll();
		
		return new ResponseEntity<>(users, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "/users/{id}")
	public ResponseEntity<UserVO> getById(@PathVariable("id") int id) {
		
		UserVO user = this.userRepository.getById(id);
		
		if (user != null) {
			
			return new ResponseEntity<>(user, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		
	}
	
}
