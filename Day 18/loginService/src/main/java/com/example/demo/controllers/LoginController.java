package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.LoginDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user/")
public class LoginController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("register")
	public ResponseEntity<Void> register(@RequestBody UserEntity user){
		this.service.saveUser(user);
		return ResponseEntity.status(200).body(null);
	}
	
	@PostMapping("login")
	public ResponseEntity<String> login(@RequestBody LoginDto dto){
		
		return this.service.
	}
	

}
