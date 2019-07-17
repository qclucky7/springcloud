package com.example.cloudhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@EnableHystrixDashboard
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class CloudHystrixdashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixdashboardApplication.class, args);
    }

}
