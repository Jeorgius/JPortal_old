package com.jeorgius.security_oauth.rest;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin(
        origins = {"http://localhost:4200","http://localhost:8777"},
        allowedHeaders = "origin, content-type, accept, authorization",
        allowCredentials = "true",
        maxAge = 1209600
)
@Order(102)
public class Rest {

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}
