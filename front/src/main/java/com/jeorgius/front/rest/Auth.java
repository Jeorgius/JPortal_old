package com.jeorgius.front.rest;

import com.jeorgius.front.validation.extractors.CredsExtractor;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
  public Object isLogged(Principal principal){
//    boolean isLogged;
//    if(principal!=null) isLogged = true; principal->userAuthentication->details->get("response").get("first_name"/"last_name"))
//    return isLogged;
    if (principal!=null) {
      //UserDetails details = ((UserDetails) principal);
      OAuth2Authentication a = (OAuth2Authentication)principal;
      LinkedHashMap c = (LinkedHashMap) a.getUserAuthentication().getDetails(); // has response and email
      List d = (ArrayList) c.get("response"); //fb -> c.get("name")
      LinkedHashMap e = (LinkedHashMap) d.get(0);
      String fullUserName = e.get("first_name") + " " + e.get("last_name");
      //WebAuthenticationDetails w = (WebAuthenticationDetails)a.getDetails();
      //HashMap h = (HashMap)a.getDetails();
      //HashMap b = (HashMap) h.get("response");
      //b.get("user_name");
      System.out.println(((OAuth2Authentication)principal).getCredentials());
    }
    return principal!=null;
  }



}
