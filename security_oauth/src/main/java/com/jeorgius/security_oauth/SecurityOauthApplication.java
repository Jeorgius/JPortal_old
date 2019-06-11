package com.jeorgius.security_oauth;

import com.jeorgius.lib.cfg.DatabaseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableOAuth2Client

//@EnableAuthorizationServer
@EnableDiscoveryClient
@SpringBootApplication
@EnableOAuth2Sso
@Import(DatabaseConfiguration.class)
@EnableConfigurationProperties
public class SecurityOauthApplication extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(SecurityOauthApplication.class, args);
    }
}