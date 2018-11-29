package com.jeorgius.gateway.cfg;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(URIs.class)
public class Routings {

    @Bean
    public RouteLocator rerouting(RouteLocatorBuilder builder, URIs uris){
        return builder.routes().
                route(j ->
                        j.path("/login/fb")
                                .filters(f -> f.rewritePath("/login/fb", "/login"))
                                .uri(uris.getOauth())
                )
                .build();
    }
}
