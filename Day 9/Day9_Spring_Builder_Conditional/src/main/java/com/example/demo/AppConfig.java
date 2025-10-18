package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

//@Configuration
//@Order(1)
public class AppConfig {
	
	@Bean
	public String master() {
		return "master";
	}

}
