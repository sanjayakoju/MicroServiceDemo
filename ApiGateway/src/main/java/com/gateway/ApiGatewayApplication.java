package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("quiz-service", r -> r.path("/quiz/**", "/quiz-test/**")
						.uri("lb://QUIZ-SERVICE"))
				.route("question-service", r -> r.path("/question/**")
						.uri("lb://QUESTION-SERVICE"))
				.route("user-service" , r -> r.path("/users/**")
						.uri("lb://USER-SERVICE"))
				.route("hotel-service", r -> r.path("/hotels/**")
						.uri("lb://HOTEL-SERVICE"))
				.route("rating-service", r -> r.path("/ratings/**")
						.uri("lb://RATING-SERVICE"))
				.build();
	}

}
