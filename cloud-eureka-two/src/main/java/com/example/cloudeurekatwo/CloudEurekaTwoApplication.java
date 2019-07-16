package com.example.cloudeurekatwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaTwoApplication.class, args);
    }

}
