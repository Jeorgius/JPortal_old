package com.jeorgius.security_oauth.rest;

import com.jeorgius.database.Entities.Users.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Rest {

    @CrossOrigin(
            origins = "http://localhost:4200",
            allowedHeaders = "origin, content-type, accept, authorization",
            allowCredentials = "true",
            maxAge = 1209600
    )
    @GetMapping("/user")
    public User user(User user){
        return user;
    }
}
