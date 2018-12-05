package com.jeorgius.security_oauth.rest;

import com.jeorgius.database.Entities.Users.User;
import com.jeorgius.database.Entities.Users.UserFull;
import com.jeorgius.database.Entities.Users.UserPrivate;
import com.jeorgius.database.Repos.UserRepo;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
