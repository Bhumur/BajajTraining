package com.example.demo.utils;


import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouterValidator {
	public static final List<String> whiteLabels = List.of("/auth/register","/auth/login");
	
	public Predicate<ServerHttpRequest> isSecured = request -> whiteLabels.stream()
															.noneMatch(uri -> request.getURI().getPath().contains(uri));
}
