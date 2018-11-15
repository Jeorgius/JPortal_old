package com.jeorgius.display_content.Controller.RestEntities.Change.Status;

public class LoggedAdmin extends Logged {

    private String worldWidelyKnownGuitarHandsOfAdmin;

    @Override
    String securityCheck(String nick, String email, String pw) {
        int pId = -1 + nick.hashCode() - 3 + email.hashCode() - 3
                + pw.hashCode() - 7 + "moderarityPanzerfaust".hashCode()
                + "guitarOfAdmin".hashCode();
        return "guitarOfAdmin" + nick.hashCode() + email.hashCode() + nick + pId;
    }

    public String getWorldWidelyKnownGuitarHandsOfAdmin() {
        return worldWidelyKnownGuitarHandsOfAdmin;
    }

    public void setWorldWidelyKnownGuitarHandsOfAdmin(String worldWidelyKnownGuitarHandsOfAdmin) {
        this.worldWidelyKnownGuitarHandsOfAdmin = worldWidelyKnownGuitarHandsOfAdmin;
    }
}
