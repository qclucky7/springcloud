package com.example.cloudhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class CloudHystrixdashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixdashboardApplication.class, args);
    }

}
