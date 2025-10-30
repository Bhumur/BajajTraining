package com.example.demo.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RouterValidator;

import reactor.core.publisher.Mono;

@Component
public class AuthenticationFilter implements GlobalFilter {

	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Autowired
	private RouterValidator validator;
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		ServerHttpRequest request = exchange.getRequest();
//		request.getHeaders().forEach((k,v)->System.out.println(k + " " + v));
		if(validator.isSecured.test(request)) {
			System.out.println("0");
			if(!request.getHeaders().containsKey("Authorization")) {
				System.out.println("1");
				return this.onError(exchange, "Authorization header is missing", HttpStatus.UNAUTHORIZED);
			}
		
		final String authHeader = request.getHeaders().getFirst("Authorization");
		
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			System.out.println("2");
			return this.onError(exchange, "Invalid Authorization formate", HttpStatus.UNAUTHORIZED);
		}
		
		final String token = authHeader.substring(7);
		
		if(!jwtUtil.isTokenValid(token)){
			System.out.println("3 " + token);
			return this.onError(exchange, "JWT validation failed or token is expried", HttpStatus.UNAUTHORIZED);
		}
		
		String username = jwtUtil.extractUsername(token);
		ServerHttpRequest mutatedRequest = exchange.getRequest().mutate()
				.header("X-Auth-User", username)
				.build();
		
		return chain.filter(exchange.mutate().request(mutatedRequest).build());
		}
		return chain.filter(exchange);
	}

	private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus){
		ServerHttpResponse response = exchange.getResponse();
		
		response.setStatusCode(httpStatus);
		
		return response.setComplete();
		
		
	}
}
