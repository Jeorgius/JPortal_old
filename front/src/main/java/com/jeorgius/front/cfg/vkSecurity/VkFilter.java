package com.jeorgius.front.cfg.vkSecurity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.filter.OAuth2AuthenticationFailureEvent;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VkFilter extends AbstractAuthenticationProcessingFilter {

  private String vkUserInfoUri;
  private String openApi_v;
  private String scope;

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
    } catch (OAuth2Exception e){
      BadCredentialsException bad = new BadCredentialsException("Could not obtain user details from token",e);
      publish(new OAuth2AuthenticationFailureEvent(bad));
      throw bad;
    }

    try{
      String userInfoEndpointUrl = vkUserInfoUri
      +"?client_id"+tokenService.getUserInfoEndpointUrl()
        +"&uids="+accessToken.getAdditionalInformation().get("user_id").toString()
        +"&redirect_uri=https://localhost:8007/login/vk"
        +"&access_token="+accessToken
        +"&v="+openApi_v
        +"&scope="+scope;
      tokenService.setUserInfoEndpointUrl(userInfoEndpointUrl);

      OAuth2Authentication result = tokenService.loadAuthentication(accessToken.getValue());
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
  public String getVkUserInfoUri() {
    return vkUserInfoUri;
  }
  public void setVkUserInfoUri(String vkUserInfoUri) {
    this.vkUserInfoUri = vkUserInfoUri;
  }
  public String getOpenApi_v() {
    return openApi_v;
  }
  public void setOpenApi_v(String openApi_v) {
    this.openApi_v = openApi_v;
  }
  public String getScope() {
    return scope;
  }
  public void setScope(String scope) {
    this.scope = scope;
  }
}
