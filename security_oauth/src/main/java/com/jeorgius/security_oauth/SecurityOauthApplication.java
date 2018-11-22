package com.jeorgius.security_oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@EnableOAuth2Client
@EnableAuthorizationServer
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class SecurityOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityOauthApplication.class, args);
    }
}
