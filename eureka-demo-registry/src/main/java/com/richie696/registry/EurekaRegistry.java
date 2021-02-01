package com.richie696.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaRegistry {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRegistry.class, args);
    }
}
