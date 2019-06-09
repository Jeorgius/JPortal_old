package com.jeorgius.display_content.Controller.Logic;

import com.jeorgius.database.entities.Users.User;
import com.jeorgius.database.entities.Users.UserFull;
import com.jeorgius.database.entities.Users.UserPrivate;
import com.jeorgius.database.repos.UserPrivateRepo;
import com.jeorgius.database.repos.UserRepo;
import com.jeorgius.display_content.Controller.RestEntities.Change.LoginUser;
import com.jeorgius.display_content.Controller.RestEntities.Change.RegisterUser;
import com.jeorgius.display_content.Controller.RestEntities.Change.Status.Logged;
import com.jeorgius.display_content.Controller.RestEntities.Change.Status.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateInput {

    private UserRepo userRepo;
    private UserPrivateRepo userPrivateRepo;

    @Autowired
    public ValidateInput(UserRepo userRepo, UserPrivateRepo userPrivateRepo) {
        this.userRepo = userRepo;
        this.userPrivateRepo = userPrivateRepo;
    }

    long convertToLong(String id) {
        try {
            return Long.parseLong(id);
        } catch (Exception e) {
            return -1;
        }
    }

    public String registerMsg(RegisterUser registerUser) {
        if (registerUser.getNick() == null || registerUser.getNick().equals("")) return "Nickname not entered";
        if (registerUser.getEmail() == null || registerUser.getEmail().equals("")) return "Email not entered";
        if (registerUser.getPw() == null || registerUser.getPw().equals("")) return "Password not entered";
        if (userRepo.findOneByNickname(registerUser.getNick()) != null) return "User with such nickname already exists";
        if (userPrivateRepo.findOneByEmail(registerUser.getEmail()) != null)
            return "User with such email already exists";


        User user = new User(registerUser.getNick(),
                "default",
                new UserPrivate(registerUser.getEmail(),
                        registerUser.getPw(),
                        1),
                new UserFull("Here should be users' text"));
        user.getUserPrivate().setUser(user);
        userRepo.save(user);

        return "You have successfully registered on this website!";
    }

    public Logged loginUser(LoginUser loginUser) {
        UserPrivate foundUser = userPrivateRepo.findOneByEmail(loginUser.getEmail());
        if (loginUser.getPw().equals(foundUser.getPw()) && foundUser.getRank() == 1)
            return new LoggedUser(foundUser.getUser().getNickname(), loginUser.getEmail(), new User());

        return new LoggedUser();
    }
}
