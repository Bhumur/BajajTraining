package com.example.demo.config;

import com.example.demo.ApiGatewayApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {


	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p->p.path("/api/v1/reviews/**").uri("lb://REVIEWSERVICE"))
				.route(p->p.path("/api/v1/books/**").uri("lb://BOOKSERVICE"))
				.route(p->p.path("/api/v1/catalogs/**").uri("lb://CATALOGSERVICE"))
				.route(p->p.path("/api/v2/reviews/**").uri("lb://REVIEWSERVICE"))
				.build();
	}
}
