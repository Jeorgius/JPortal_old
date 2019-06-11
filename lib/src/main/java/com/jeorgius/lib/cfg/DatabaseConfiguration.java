package com.jeorgius.lib.cfg;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.ResourceUtils;

@Configuration
@ComponentScan(basePackages = "com.jeorgius.lib")
@EnableJpaRepositories(basePackages = "com.jeorgius.lib.repos")
@EntityScan(basePackages = "com.jeorgius.lib.entities")
@PropertySource(ResourceUtils.CLASSPATH_URL_PREFIX + "database.yml")
public class DatabaseConfiguration {
}
