package com.dk.project_board0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@ConfigurationPropertiesScan
@SpringBootApplication
public class ProjectBoard0Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectBoard0Application.class, args);
    }

}
