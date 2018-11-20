package com.jeorgius.database.Configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.ResourceUtils;

@Configuration
@ComponentScan(basePackages = "com.jeorgius.database")
@EnableJpaRepositories(basePackages = "com.jeorgius.database.Repos")
@EntityScan(basePackages = "com.jeorgius.database.Entities")
@PropertySource(ResourceUtils.CLASSPATH_URL_PREFIX + "database.properties")
public class DatabaseConfiguration {
}
