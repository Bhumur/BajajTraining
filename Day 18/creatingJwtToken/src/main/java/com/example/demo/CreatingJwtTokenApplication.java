package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.service.CreateTokenService;

@SpringBootApplication
@EnableDiscoveryClient
public class CreatingJwtTokenApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(CreatingJwtTokenApplication.class, args);
		
		CreateTokenService service = ctx.getBean(CreateTokenService.class);
		
		System.out.println(service.generateToken("bhumur"));
	}

}
