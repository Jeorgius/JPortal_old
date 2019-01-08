package com.jeorgius.front.validation.extractors;

import java.security.Principal;
import java.util.Map;

public interface SocialExtractor {
    Map extractCreds(Principal principal);
}
