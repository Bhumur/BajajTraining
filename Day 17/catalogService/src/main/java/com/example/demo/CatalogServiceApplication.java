package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.CatalogDto;

@SpringBootApplication
@EnableDiscoveryClient
public class CatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	WebClient.Builder loadBalanced(){
		return WebClient.builder();
	}
	
	@Bean
	WebClient client(WebClient.Builder builder) {
		return builder.build();
	}
	
	@Bean
	CatalogDto dto() {
		return new CatalogDto();
	}
}
