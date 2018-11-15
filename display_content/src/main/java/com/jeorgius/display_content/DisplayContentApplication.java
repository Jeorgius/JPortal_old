package com.jeorgius.display_content;

import com.jeorgius.cfg.Configuration.DatabaseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DatabaseConfiguration.class)
public class DisplayContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DisplayContentApplication.class, args);
    }
}
