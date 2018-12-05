package com.jeorgius.security_oauth.cfg;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.net.ssl.HttpsURLConnection;

@EnableWebSecurity
@Configuration
@EnableConfigurationProperties
@Order(101)
public class Cfg extends WebSecurityConfigurerAdapter {

    public Cfg(){
        HttpsURLConnection.setDefaultHostnameVerifier(
                (hostname, sslSession) -> hostname.equals("localhost")
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/","/user", "/login**", "/webjars**", "/error**")
                .permitAll()
            .anyRequest()
            .authenticated();
//            .and()
//            .csrf().disable();
    }


}
