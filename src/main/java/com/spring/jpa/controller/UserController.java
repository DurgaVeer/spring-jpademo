package com.spring.jpa.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.entity.UserEntity;
import com.spring.jpa.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping(value = "/create")
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
		user.setCreateDate(LocalDateTime.now());
		userService.saveUser(user);
		return ResponseEntity.ok(user);
	}
	@GetMapping(value = "/getAll")
	public List<UserEntity> getAllUsers() { 
		return userService.getAll();
	}
	@GetMapping(value = "/get/{id}")
	public UserEntity getByID(@PathVariable("id") UUID  id) { 
		
		Optional<UserEntity> userOptional = userService.getByID(id);
		
		return userOptional.get();
	}
	@PutMapping(value = "/update")
	public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) {
		user.setCreateDate(LocalDateTime.now());
		userService.updateUser(user);
		return ResponseEntity.ok(user);
	}
	@DeleteMapping(value="/delete")
	public ResponseEntity<UserEntity> deleteUser(@RequestBody UserEntity user) {
		user.setCreateDate(LocalDateTime.now());
		userService.deleteUser(user);
		return ResponseEntity.ok(user);
	
}
}