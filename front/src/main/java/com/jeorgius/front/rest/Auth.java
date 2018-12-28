package com.jeorgius.front.rest;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@CrossOrigin
@RestController
public class Auth {

  @RequestMapping("/login/fb")
  public Principal user(Principal principal) {
    return principal;
  }
  @RequestMapping("/userinfo")
  public Principal userInfo(Principal principal){
    return principal;
  }
  @RequestMapping("/test")
  public Principal userTest(Principal principal){
    return principal;
  }

}
