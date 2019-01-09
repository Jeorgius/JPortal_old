package com.jeorgius.front.validation.extractors.impl;

import com.jeorgius.front.validation.extractors.impl.SocialExtractor;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.security.Principal;
import java.util.*;

public class VkCredsExtractor implements SocialExtractor {

    @Override
    public Map extractCreds(Principal principal) {
        Map<String,Object> creds = new HashMap<>();
        LinkedHashMap vkDetails = ((LinkedHashMap)
                ((OAuth2Authentication) principal)
                .getUserAuthentication().getDetails());

        LinkedHashMap vkCreds = ((LinkedHashMap)((ArrayList)vkDetails.get("response")).get(0));

        creds.put("id", vkCreds.get("user_id"));
        creds.put("name", vkCreds.get("first_name"));
        creds.put("surname", vkCreds.get("last_name"));
        creds.put("email", vkDetails.get("email"));
        return creds;
    }
}
