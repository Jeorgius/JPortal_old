package com.jeorgius.display_content.Controller.RestEntities.Change.Status;

public abstract class Logged {

    private String nick;
    private String email;
    private String pw;
    private int rank;

    abstract String securityCheck(String nick, String email, String pw);

    public Logged() {
    }

    public Logged(String nick, String email, int rank) {
        this.nick = nick;
        this.email = email;
        this.rank = rank;
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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}

