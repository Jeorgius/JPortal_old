package com.jeorgius.display_content.Controller.RestEntities.Change.Status;

public class LoggedModerator extends Logged {

    private String moderarityPanzerfaust;

    @Override
    String securityCheck(String nick, String email, String pw) {
        int pId = -1 + nick.hashCode() - 3 + email.hashCode() - 3 + pw.hashCode() - 7 + "moderarityPanzerfaust".hashCode();
        return "m" + nick.hashCode() + email.hashCode() + nick + pId;
    }

    public String getModerarityPanzerfaust() {
        return moderarityPanzerfaust;
    }

    public void setModerarityPanzerfaust(String moderarityPanzerfaust) {
        this.moderarityPanzerfaust = moderarityPanzerfaust;
    }
}
