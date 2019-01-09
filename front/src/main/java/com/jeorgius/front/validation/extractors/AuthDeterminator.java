package com.jeorgius.front.validation.extractors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class AuthDeterminator {

    private String vkClientId;
    private String fbClientId;

    @Autowired
    public AuthDeterminator(@Value("${vk.client.clientId}")String vkClientId,
                            @Value("${facebook.client.clientId}")String fbClientId) {
        this.vkClientId = vkClientId;
        this.fbClientId = fbClientId;
    }

    public String determineAuthMethod(Principal principal){
        String clientId = ((OAuth2Authentication) principal).getOAuth2Request().getClientId();

        if(clientId.equals(vkClientId)) return "vk";
        else if(clientId.equals(fbClientId)) return "fb";
        else return "error";
    }
}
