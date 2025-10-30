package com.example.demo.filter;

import java.util.function.Consumer;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest.Builder;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class InterceptingFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		ServerHttpRequest req = exchange.getRequest().mutate().header("RequesthEEEEEEEEEEEEEEEEEEE", "Set y Dev").build();
		
		exchange.getResponse().getHeaders().add("Heeeeeeeeeeeeeeeeeeeeeeeeelo", "Heeeeeeeeeeeeeeeeeeeeeeeeeel");
		
		
		return chain.filter(exchange.mutate().request(req).build());
	}

}
