package com.example.cloudeurekathree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaThreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaThreeApplication.class, args);
    }

}
