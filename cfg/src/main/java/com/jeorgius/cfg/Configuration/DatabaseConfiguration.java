package com.jeorgius.cfg.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.ResourceUtils;

@Configuration
@ComponentScan(basePackages = "com.jeorgius.cfg")
@ConfigurationProperties
@PropertySource(ResourceUtils.CLASSPATH_URL_PREFIX + "database.properties")
public class DatabaseConfiguration {
}
