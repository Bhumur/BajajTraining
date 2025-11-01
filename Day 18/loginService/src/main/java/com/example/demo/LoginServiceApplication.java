package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@SpringBootApplication
public class LoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			@Autowired
			UserService service;
			
			@Autowired
			BCryptPasswordEncoder encoder;
			
			@Override
			public void run(String... args) throws Exception {
//				this.service.saveUser(new UserEntity(1010, "india", encoder.encode("india"), "ROLE_ADMIN"));
//				this.service.saveUser(new UserEntity(2020, "bhutan", encoder.encode("bhutan"), "ROLE_GUEST"));
			}
		};
	}
	
	
}
