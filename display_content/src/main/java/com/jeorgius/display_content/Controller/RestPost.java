package com.jeorgius.display_content.Controller;

import com.jeorgius.display_content.Controller.Logic.ValidateInput;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestPost {

    private ValidateInput vI;

//    @Autowired
//    public RestPost(ValidateInput vI) {
//        this.vI = vI;
//    }
//
//    @PostMapping
//    public String registerUser(RegisterUser registerUser) {
//        return vI.registerMsg(registerUser);
//    }
//
//    @PostMapping
//    public Logged login(LoginUser loginUser) {
//        return null;
//    }
}
