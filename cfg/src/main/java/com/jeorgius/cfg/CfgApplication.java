package com.jeorgius.cfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.ResourceUtils;

@SpringBootApplication
@EnableConfigServer
//@ComponentScan(basePackages = "com.jeorgius.cfg")
//@PropertySource(ResourceUtils.CLASSPATH_URL_PREFIX + "database.properties")
public class CfgApplication {

    public static void main(String[] args) {
        SpringApplication.run(CfgApplication.class, args);
    }
}
