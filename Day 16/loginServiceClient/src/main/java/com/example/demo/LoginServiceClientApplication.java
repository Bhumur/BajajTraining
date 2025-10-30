package com.example.demo;


import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class LoginServiceClientApplication {

	public static void main(String[] args) throws InterruptedException {
	 	ConfigurableApplicationContext ctx = SpringApplication.run(LoginServiceClientApplication.class, args);
	 	
	 	WebClient client = ctx.getBean(WebClient.class);
	 	
	 	Mono<String> response = client.get()
								 	.uri("http://localhost:5080/api/v1/secured")
								 	.header(HttpHeaders.AUTHORIZATION,
								 			"Basic " + Base64.getEncoder()
								 			.encodeToString("india:india".getBytes()))
								 	.retrieve().bodyToMono(String.class);
//	 	Thread.sleep(5000);
//	 	System.out.println(client.get()
//			 	.uri("http://localhost:5080/api/v1/secured")
//			 	.header(HttpHeaders.AUTHORIZATION,
//			 			"Basic " + Base64.getEncoder()
//			 			.encodeToString("india:india".getBytes()))
//			 	.retrieve().bodyToMono(String.class).block());
//	 	System.out.println(response.block());
	 	response.subscribe(e -> System.out.println(e));
//	 	ctx.close();
	}
	
	@Bean
	WebClient.Builder loadBalanced(){
		return WebClient.builder();
	}
	
	@Bean
	WebClient client(WebClient.Builder builder) {
		return builder.build();
	}

}
