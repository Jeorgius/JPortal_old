package com.jeorgius.front.validation.extractors.impl;

import java.security.Principal;
import java.util.Map;

public interface SocialExtractor {
    Map extractCreds(Principal principal);
}
