package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.ifaces.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public UserEntity getUserByUsername(String username) {
		return this.repo.findByUsername(username).orElseThrow();
	}

	public UserEntity saveUser(UserEntity userEntity) {

		return this.repo.save(userEntity);
	}
}
