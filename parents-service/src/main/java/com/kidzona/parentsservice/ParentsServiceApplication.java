package com.kidzona.parentsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@EnableAutoConfiguration

@SpringBootApplication
public class ParentsServiceApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ParentsServiceApplication.class, args);
        System.out.print("worked correctly");
    }
    
    
}
