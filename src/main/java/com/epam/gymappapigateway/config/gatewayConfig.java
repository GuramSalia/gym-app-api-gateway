package com.epam.gymappapigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class gatewayConfig {
    @Bean
    public RouteLocator gatewayLocator(RouteLocatorBuilder builder) {
        return builder.routes().route(
                p -> p
                        .path("/gym-app/**")
                        .uri("lb://MAIN-SERVICE")
        ).build();
    }
}
