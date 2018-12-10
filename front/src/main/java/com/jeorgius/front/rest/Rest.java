package com.jeorgius.front.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Rest {
  //handles 404 on refresh F5
  @RequestMapping(value = "/**/{[path:[^\\.]*}")
  public String mainPage(Model model){
    return "forward:/";
  }
}
