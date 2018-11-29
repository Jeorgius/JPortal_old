package com.jeorgius.gateway.cfg;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class URIs {
    private String oauth = "https://localhost:8007";

    public String getOauth() {
        return oauth;
    }

    public void setOauth(String oauth) {
        this.oauth = oauth;
    }
}
