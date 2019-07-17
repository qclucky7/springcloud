package com.example.cloudclienttwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudClientTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudClientTwoApplication.class, args);
    }

}
