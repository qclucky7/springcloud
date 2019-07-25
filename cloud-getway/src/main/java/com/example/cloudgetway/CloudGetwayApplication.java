package com.example.cloudgetway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudGetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGetwayApplication.class, args);
    }

}
