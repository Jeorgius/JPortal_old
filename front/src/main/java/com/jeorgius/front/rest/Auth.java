package com.jeorgius.front.rest;

import com.jeorgius.front.validation.extractors.CredsExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@CrossOrigin
@RestController
public class Auth {
  private CredsExtractor credsExtractor;

  @Autowired
  public Auth(CredsExtractor credsExtractor) {
    this.credsExtractor = credsExtractor;
  }

  @RequestMapping("/userinfo")
  public Principal userInfo(Principal principal){
    return principal;
  }

  @RequestMapping("/login/islogged")
  public Map isLogged(Principal principal){
    if (principal!=null) return credsExtractor.extractCreds(principal);
    return new HashMap();
  }



}
