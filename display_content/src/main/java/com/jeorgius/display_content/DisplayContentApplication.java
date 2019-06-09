package com.jeorgius.display_content;

import com.jeorgius.database.cfg.DatabaseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
@Import(DatabaseConfiguration.class)
public class DisplayContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DisplayContentApplication.class, args);
    }
}
