package com.eDukan.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class APIGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(APIGatewayApplication.class, args);
    }
}
