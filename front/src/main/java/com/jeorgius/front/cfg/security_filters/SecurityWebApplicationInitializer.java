package com.jeorgius.front.cfg.security_filters;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.multipart.support.MultipartFilter;

import javax.servlet.ServletContext;

public class UploadFilter extends AbstractSecurityWebApplicationInitializer {

    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        //Allows to upload files to everyone, who gets access to REST
        insertFilters(servletContext, new MultipartFilter());
    }
}
