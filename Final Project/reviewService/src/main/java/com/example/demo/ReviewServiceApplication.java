package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableDiscoveryClient
public class ReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewServiceApplication.class, args);
		
		Flux<String> names = Flux.just("Ramesh","Suresh","Mahesh","Rajesh");
		
		Mono<String> city = Mono.just("Jaipur");
		
		names.subscribe(System.out::println);
		
		city.subscribe(System.out::println);
		
		names.subscribe(t->System.out.println("Next : " +t),
				e->System.err.println("Error : " +e.getMessage()),
				()->System.out.println("Completed"));
		
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
