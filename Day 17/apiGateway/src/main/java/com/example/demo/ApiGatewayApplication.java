package com.example.demo;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseCookie;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class ApiGatewayApplication {

	Logger log = org.slf4j.LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Bean
	GlobalFilter postFilter() {
		return (exchange, chain) -> {
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				System.err.println("post : "+LocalDateTime.now());
				log.info("Post Filter Called");
				exchange.getResponse().addCookie(ResponseCookie.from("setByPostFilter", "BlackAndWhite").build());
			}));
		};
	}

}
