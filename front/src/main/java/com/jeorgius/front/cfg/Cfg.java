package com.jeorgius.front.cfg;

import com.jeorgius.front.cfg.vkSecurity.VkFilter;
import com.jeorgius.front.cfg.vkSecurity.VkTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.CompositeFilter;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

@EnableOAuth2Client
@Configuration
@Order(SecurityProperties.IGNORED_ORDER)
public class Cfg extends WebSecurityConfigurerAdapter {
//  public Cfg(){
//    HttpsURLConnection.setDefaultHostnameVerifier(
//      (hostname, sslSession) -> hostname.equals("localhost")
//    );
//  }
  private OAuth2ClientContext oAuth2ClientContext;
  private VkTokenService vkTokenService;

  @Autowired
  public Cfg(OAuth2ClientContext oAuth2ClientContext, VkTokenService vkTokenService){
    this.oAuth2ClientContext = oAuth2ClientContext;
    this.vkTokenService = vkTokenService;
  }

  @Bean
  @ConfigurationProperties("facebook.client")
  public AuthorizationCodeResourceDetails facebook(){
    return new AuthorizationCodeResourceDetails();
  }

  @Bean
  @ConfigurationProperties("facebook.resource")
  public ResourceServerProperties facebookResource(){
    return new ResourceServerProperties();
  }

  @Bean
  @ConfigurationProperties("vk.client")
  public AuthorizationCodeResourceDetails vk(){
    return new AuthorizationCodeResourceDetails();
  }

  @Bean
  @ConfigurationProperties("vk.resource")
  public ResourceServerProperties vkResource(){
    return new ResourceServerProperties();
  }

  @Bean
  public FilterRegistrationBean filterRegistration(OAuth2ClientContextFilter filter){
    FilterRegistrationBean reg = new FilterRegistrationBean();
    reg.setFilter(filter);
    reg.setOrder(-100);
    return reg;
  }
  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http
        .addFilterAfter(new CsrfFilterCustom(), CsrfFilter.class)
        .antMatcher("/**")
        .authorizeRequests()
        .antMatchers(
          "/", "/news/**","/**.js","/index.html", "/assets/**",
          "/photos/**","/about", "/users/**","/register","/store/**","/music/**","/**.ico"
        ).permitAll()
        .antMatchers("/login/**").permitAll()
        .antMatchers("/test**").permitAll()
        .antMatchers("/userinfo").authenticated()
        .anyRequest().authenticated()
//        .antMatchers("/admin/").hasRole("ADMIN")
      .and()
        .addFilterBefore(ssoRedirectFilter(), BasicAuthenticationFilter.class)
        .csrf()
          .ignoringAntMatchers("/login/**")
          .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
      .and()
      .logout().logoutUrl("/login/logout")
        .clearAuthentication(true)
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
      .logoutSuccessUrl("/").permitAll();
  }

  private CsrfTokenRepository csrfTokenRepository(){
    HttpSessionCsrfTokenRepository repo = new HttpSessionCsrfTokenRepository();
    repo.setHeaderName("X-XSRF-TOKEN");
    return repo;
  }

  private Filter ssoRedirectFilter(){
    CompositeFilter filter = new CompositeFilter();
    List<Filter> filters = new ArrayList<>();
    OAuth2ClientAuthenticationProcessingFilter fbFilter = new OAuth2ClientAuthenticationProcessingFilter("/login/fb");
    OAuth2RestTemplate fbTemplate = new OAuth2RestTemplate(facebook(), oAuth2ClientContext);
    fbFilter.setRestTemplate(fbTemplate);
    UserInfoTokenServices fbTokenServices = new UserInfoTokenServices(facebookResource().getUserInfoUri(),facebook().getClientId());
    fbTokenServices.setRestTemplate(fbTemplate);
    fbFilter.setTokenServices(fbTokenServices);
    filters.add(fbFilter);

    VkFilter vkFilter = new VkFilter("/login/vk");
    OAuth2RestTemplate vkTemplate = new OAuth2RestTemplate(vk(), oAuth2ClientContext);
    vkFilter.setRestTemplate(vkTemplate);
    vkTokenService.setRestTemplate(vkTemplate);
    vkFilter.setTokenService(vkTokenService);
    filters.add(vkFilter);

    filter.setFilters(filters);
    return filter;
  }


}
