package com.jeorgius.front.validation.extractors;

import com.jeorgius.front.validation.extractors.impl.FbCredsExtractor;
import com.jeorgius.front.validation.extractors.impl.SocialExtractor;
import com.jeorgius.front.validation.extractors.impl.VkCredsExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Map;

@Service
public class CredsExtractor {

    private AuthDeterminator ad;

    @Autowired
    public CredsExtractor(AuthDeterminator ad) {
        this.ad = ad;
    }

    private SocialExtractor createExtractor(Principal principal){
        String authSource = ad.determineAuthMethod(principal);
        if(authSource.equals("vk")) return new VkCredsExtractor();
        else if (authSource.equals("fb")) return new FbCredsExtractor();
        else return new FbCredsExtractor();
    }

    public Map extractCreds(Principal principal){
        return createExtractor(principal).extractCreds(principal);
    }
}
