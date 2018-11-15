package com.jeorgius.cfg.Entities.Users;

import javax.persistence.*;

@Entity
@Table(name="users", schema="users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String name;
    private String surname;
    private String avatar_path;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserPrivate userPrivate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserFull userFull;

    public User(){}

    public User(String nickname, String avatar_path, UserPrivate userPrivate, UserFull userFull) {
        this.nickname = nickname;
        this.avatar_path = avatar_path;
        this.userPrivate = userPrivate;
        this.userFull = userFull;
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

    public UserPrivate getUserPrivate() {
        return userPrivate;
    }

    public void setUserPrivate(UserPrivate userPrivate) {
        this.userPrivate = userPrivate;
    }

    public UserFull getUserFull() {
        return userFull;
    }

    public void setUserFull(UserFull userFull) {
        this.userFull = userFull;
    }
}
