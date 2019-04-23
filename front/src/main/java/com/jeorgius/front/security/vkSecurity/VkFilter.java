package com.jeorgius.front.cfg.vkSecurity;

import org.springframework.context.ApplicationEvent;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.filter.OAuth2AuthenticationFailureEvent;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VkFilter extends AbstractAuthenticationProcessingFilter {

  public OAuth2RestOperations restTemplate;
  private VkTokenService tokenService;

  public VkFilter(String defaultFilterProcessUrl){
    super(defaultFilterProcessUrl);
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse resp) throws AuthenticationException {
    OAuth2AccessToken accessToken;
    try {
      accessToken = restTemplate.getAccessToken();

      OAuth2Authentication result = tokenService.exchangeTokenWithInfo(accessToken);
      if(authenticationDetailsSource!=null){
        req.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_VALUE,accessToken.getValue());
        req.setAttribute(OAuth2AuthenticationDetails.ACCESS_TOKEN_TYPE,accessToken.getTokenType());
        result.setDetails(authenticationDetailsSource.buildDetails(req));
      }
      publish(new AuthenticationSuccessEvent(result));
      return result;
    } catch (InvalidTokenException e){
      BadCredentialsException bad = new BadCredentialsException("Could not obtain user details from token",e);
      publish(new OAuth2AuthenticationFailureEvent(bad));
      throw bad;
    }
  }

  private void publish(ApplicationEvent event){
    if(eventPublisher!=null) eventPublisher.publishEvent(event);
  }
  public void setRestTemplate(OAuth2RestOperations restTemplate) {
    this.restTemplate = restTemplate;
  }
  public void setTokenService(VkTokenService tokenService) {
    this.tokenService = tokenService;
  }
}
