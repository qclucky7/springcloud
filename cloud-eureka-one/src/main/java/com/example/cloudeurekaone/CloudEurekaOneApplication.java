package com.example.cloudeurekaone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaOneApplication.class, args);
    }

}
