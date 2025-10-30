package com.example.demo.filter;


import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;

import com.example.demo.ApiGatewayApplication;
import org.slf4j.Logger;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class UniversalFilter implements GlobalFilter{

    private final InterceptingFilter interceptingFilter;

    private final ApiGatewayApplication apiGatewayApplication;
	
	
	Logger log = org.slf4j.LoggerFactory.getLogger(getClass());


    UniversalFilter(ApiGatewayApplication apiGatewayApplication, InterceptingFilter interceptingFilter) {
        this.apiGatewayApplication = apiGatewayApplication;
        this.interceptingFilter = interceptingFilter;
    }
	
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		
		
		try {
			logger(exchange);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("outside");
		
		if(exchange.getRequest().getURI().getPath().equals("/api/v1/secured")) {
			System.out.println("inside");

			String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
			String base64Credentials = authHeader.substring("Basic ".length()).trim();
			
			byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
			String credentials = new String(decodedBytes, StandardCharsets.UTF_8);
			
			String[] parts = credentials.split(":",2);
			
			String username = parts[0];
			String password = parts[1];
			
			log.info("======== UserName ========" + username + " =========== Password ============== " + password);
			
			
			if(username.equals("india") && password.equals("")) {
				exchange.getResponse().setStatusCode(HttpStatusCode.valueOf(401));
				return exchange.getResponse().setComplete(); // 
			}
			
		}
		
		return chain.filter(exchange);
	}


	private void logger(ServerWebExchange exchange) throws InterruptedException {
		System.err.println("Pre" +  LocalDateTime.now());
		ServerHttpRequest request = exchange.getRequest();
		
		ServerHttpResponse response = exchange.getResponse();
		
		request.getHeaders().forEach((a,b)->System.out.println(a + "          " + b));
		Thread.sleep(2000);
		log.info("=================    " + request.getURI().getPath() + "  Recived");
		
		log.info("================= Status Code   " + response.getStatusCode());
	}

}
