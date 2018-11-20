package com.jeorgius.display_content.Controller.RestEntities.Change.Status;

import com.jeorgius.database.Entities.Users.User;

public class LoggedUser extends Logged {

    private User user;

    public LoggedUser(){}
    public LoggedUser(String nick, String email, User user) {
        this.setNick(nick);
        this.setEmail(email);
        this.user = user;
    }

    @Override
    String securityCheck(String nick, String email, String pw) {
        int pId = nick.hashCode() + email.hashCode() + pw.hashCode();
        return nick.hashCode() - email.hashCode() + nick + pId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
