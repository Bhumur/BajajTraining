package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
/**
 *  Order Service Should expose an endpoint that accepts the bookNmae,
 *  and should return the book and its reviews
 *  and it should expose an endpoints that takes qty ordered and deducted the quantity in bookservice 
 */
@SpringBootApplication
public class OrderServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
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

}
