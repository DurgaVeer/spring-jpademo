package com.spring.jpa.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jpa.entity.UserEntity;
import com.spring.jpa.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void saveUser(UserEntity user){
		userRepository.save(user);
	}

	
	
		public List<UserEntity> getAll(){
			return (List<UserEntity>) userRepository.findAll();
		
	}



		public Optional<UserEntity> getByID(UUID id) {
			
			return userRepository.findById(id);
		}

		public void updateUser(UserEntity user){
			userRepository.save(user);
		}



		public void deleteUser(UserEntity user) {
			userRepository.delete(user);
			
		}
}
