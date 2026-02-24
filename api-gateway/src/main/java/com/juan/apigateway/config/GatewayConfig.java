package com.juan.apigateway.config;

import com.juan.apigateway.filter.JwtAuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private final JwtAuthenticationFilter filter;

    public GatewayConfig(JwtAuthenticationFilter filter) {
        this.filter = filter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                // Ruta para el Microservicio de Storage (S3)
                .route("ms-storage", r -> r.path("/api/files/**")
                        .filters(f -> f.filter(filter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("http://localhost:8082"))

                // Ruta hacia el Auth-Service (Esta NO lleva filtro para poder loguearse)
                .route("ms-auth", r -> r.path("/api/auth/**")
                        .uri("http://localhost:8081"))
                .build();
    }
}