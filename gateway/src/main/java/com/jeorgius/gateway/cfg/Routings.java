package com.jeorgius.gateway.cfg;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.HttpsURLConnection;

@Configuration
@EnableConfigurationProperties(URIs.class)
public class Routings {

    public Routings(){
        HttpsURLConnection.setDefaultHostnameVerifier(
                (hostname, sslSession) -> hostname.equals("localhost")
        );
    }

//    @Bean
//    public RouteLocator rerouting(RouteLocatorBuilder builder, URIs uris){
//        return builder.routes().
//                route(j ->
//                        j.path("/login/fb")
//                                .filters(f -> f.rewritePath("/login/fb", "/user"))
//                                .uri(uris.getOauth())
//                )
//                .build();
//    }
}
