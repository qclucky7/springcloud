package com.example.cloudclientthree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudClientThreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudClientThreeApplication.class, args);
    }

}
