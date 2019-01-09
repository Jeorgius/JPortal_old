package com.jeorgius.front.validation.extractors.impl;

import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.security.Principal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FbCredsExtractor implements SocialExtractor {
    @Override
    public Map extractCreds(Principal principal) {
        Map<String,Object> creds = new HashMap<>();
        LinkedHashMap fbCreds = ((LinkedHashMap)
                ((OAuth2Authentication) principal)
                        .getUserAuthentication().getDetails());

        String[] username = fbCreds.get("name").toString().split(" ");

        creds.put("id", fbCreds.get("id"));
        creds.put("name", username[0]);
        creds.put("surname", username[1]);
        creds.put("email", fbCreds.get("email"));
        return creds;
    }
}
