package com.jeorgius.security_oauth.rest;

import com.jeorgius.database.Entities.Users.User;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin/*(
        origins = {"http://localhost:4200","http://localhost:"},
        allowedHeaders = "origin, content-type, accept, authorization",
        allowCredentials = "true",
        maxAge = 1209600
)*/
@Order(102)
public class Rest {

    @RequestMapping("/user")
    public User user(Principal principal){
        User user = new User();
        user.setName(principal.getName());
        return user;
    }

    @RequestMapping("/")
    public User login(Principal principal){
        User user = new User();
        user.setName(principal.getName());
        return user;
    }
}
