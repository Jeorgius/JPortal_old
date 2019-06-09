package com.jeorgius.display_content.Controller.RestEntities.Display;

import com.jeorgius.database.entities.Users.User;
import com.jeorgius.database.entities.Users.UserFull;
import com.jeorgius.database.entities.Users.UserPrivate;

public class FullUser {
    private Long id;
    private String nickname;
    private String name;
    private String surname;
    private String avatar_path;

    private String description;

    private String email;
    private String pw;

    public FullUser() {
    }

    public FullUser(User user, UserFull userFull, UserPrivate userPrivate) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.avatar_path = user.getAvatar_path();
        this.description = userFull.getDescription();
        this.email = userPrivate.getEmail();
        this.pw = userPrivate.getPw();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAvatar_path() {
        return avatar_path;
    }

    public void setAvatar_path(String avatar_path) {
        this.avatar_path = avatar_path;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
