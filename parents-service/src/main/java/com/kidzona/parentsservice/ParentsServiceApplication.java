package com.kidzona.parentsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@EnableAutoConfiguration

@SpringBootApplication
@ComponentScan(basePackages = "com.kidzona.parentsservice")
public class ParentsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParentsServiceApplication.class, args);
        System.out.print("worked correctly");
    }

}
