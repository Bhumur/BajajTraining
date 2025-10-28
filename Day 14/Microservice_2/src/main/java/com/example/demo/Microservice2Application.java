package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Microservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice2Application.class, args);
	}
	
//	@Bean
//	@LoadBalanced
//	RestClient client(RestClient.Builder builder) {
//		return builder.baseUrl("http://MICROSERVICE-1").build();
//	}
	@Bean
    @LoadBalanced 
     RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }
	
	@Bean
	RestClient client(RestClient.Builder builder) {
		return builder.baseUrl("http://MICROSERVICE_1").build();
	}

}