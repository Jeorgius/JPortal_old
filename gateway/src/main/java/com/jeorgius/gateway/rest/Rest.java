package com.jeorgius.gateway.rest;

import com.jeorgius.gateway.cfg.URIs;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.mvc.ProxyExchange;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@EnableConfigurationProperties(URIs.class)
@CrossOrigin
public class Rest {

    @GetMapping("/login/fb")
    public ResponseEntity<?> reroutingFB(ProxyExchange<Object> proxy, URIs uris){
        return proxy.uri(uris.getOauth()+"/user").get();
    }
}
