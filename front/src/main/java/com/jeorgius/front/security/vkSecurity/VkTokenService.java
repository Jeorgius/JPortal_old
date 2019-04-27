package com.jeorgius.front.security.vkSecurity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.FixedAuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.FixedPrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VkTokenService implements ResourceServerTokenServices {

  private String vkUserInfoUri;
  private String vkOpenApi_v;
  private String vkClientScope;
  private String vkRedirectUri;
  private String clientId;

  @Autowired
  public VkTokenService(@Value("${vk.resource.userInfoUri}") String vkUserInfoUri,
                        @Value("${vk.openApi.version}") String vkOpenApi_v,
                        @Value("${vk.client.scope}") String vkClientScope,
                        @Value("${vk.client.redirectUri}") String vkRedirectUri,
                        @Value("${vk.client.clientId}") String clientId) {
    this.vkUserInfoUri = vkUserInfoUri;
    this.vkOpenApi_v = vkOpenApi_v;
    this.vkClientScope = vkClientScope;
    this.vkRedirectUri = vkRedirectUri;
    this.clientId = clientId;
  }

  private String userInfoEndpointUrl;
  private OAuth2RestOperations restTemplate;
  private String tokenType = DefaultOAuth2AccessToken.BEARER_TYPE;
  private AuthoritiesExtractor authoritiesExtractor = new FixedAuthoritiesExtractor();
  private PrincipalExtractor principalExtractor = new FixedPrincipalExtractor();
  protected final Log log = LogFactory.getLog(getClass());


  @Override
  public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {
    return extractAuth(new HashMap<>());
  }

  @Override
  public OAuth2AccessToken readAccessToken(String s) {
    throw new UnsupportedOperationException("Error reading access token");
  }

  private OAuth2Authentication extractAuth(Map<String, Object> map){
    Object principal = getPrincipal(map);
    List<GrantedAuthority> authorities = this.authoritiesExtractor.extractAuthorities(map);
    OAuth2Request request = new OAuth2Request(null,this.clientId,null,
      true,null,null,null,null,null);
    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(principal,"N/A",authorities);
    token.setDetails(map);
    return new OAuth2Authentication(request,token);
  }
  private Map<String, Object> getMap(String path, String accessToken){
    this.log.info("Getting user info from: " + path);
    try{
      OAuth2RestOperations restTemplate=this.restTemplate;
      if(restTemplate==null){
        BaseOAuth2ProtectedResourceDetails resource = new BaseOAuth2ProtectedResourceDetails();
        resource.setClientId(this.clientId);
        restTemplate = new OAuth2RestTemplate(resource);
      }
      OAuth2AccessToken existingToken = restTemplate.getOAuth2ClientContext().getAccessToken();
       if(existingToken==null|| !accessToken.equals(existingToken.getValue())){
         DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(accessToken);
         token.setTokenType(this.tokenType);
         restTemplate.getOAuth2ClientContext().setAccessToken(token);
       }
      return restTemplate.getForEntity(path,Map.class).getBody();
    } catch (Exception e){
      this.log.info("Failed to get response with user info"+e.getClass()+" "+e.getMessage());
      return Collections.singletonMap("error", "Could not fetch user details");
    }
  }

  public OAuth2Authentication exchangeTokenWithInfo(OAuth2AccessToken accessToken) throws AuthenticationException, InvalidTokenException{
    String userInfoEndpointUrl = vkUserInfoUri
      +"?client_id"+clientId
      +"&uids="+accessToken.getAdditionalInformation().get("user_id").toString()
      +"&redirect_uri="+vkRedirectUri
      +"&access_token="+accessToken
      +"&v="+vkOpenApi_v
      +"&scope="+vkClientScope;

    Map<String, Object> map = getMap(userInfoEndpointUrl,accessToken.getValue());
    if(map.containsKey("error")){
      this.log.info("userinfo returned error: "+map.get("error"));
      throw new InvalidTokenException(accessToken.getValue());
    }
    if(accessToken.getAdditionalInformation().get("email")!=null) map.put("email",accessToken.getAdditionalInformation().get("email"));
    return extractAuth(map);
  }
  public void setRestTemplate(OAuth2RestOperations restTemplate) {
    this.restTemplate = restTemplate;
  }
  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }
  public void setAuthoritiesExtractor(AuthoritiesExtractor authoritiesExtractor) {
    this.authoritiesExtractor = authoritiesExtractor;
  }
  public void setPrincipalExtractor(PrincipalExtractor principalExtractor) {
    this.principalExtractor = principalExtractor;
  }
  protected Object getPrincipal(Map<String,Object> map){
    Object principal = this.principalExtractor.extractPrincipal(map);
    return principal==null? "Error getting principal" : principal;
  }

}
