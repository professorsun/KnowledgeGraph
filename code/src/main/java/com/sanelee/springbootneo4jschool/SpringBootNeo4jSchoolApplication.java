package com.sanelee.springbootneo4jschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootNeo4jSchoolApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootNeo4jSchoolApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootNeo4jSchoolApplication.class);
    }
}
