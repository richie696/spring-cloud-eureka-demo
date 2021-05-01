package com.richie696.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EntityScan("com.richie696.**.domain")
@EnableDiscoveryClient
public class LoginServiceProvider {

    public static void main(String[] args) {
        SpringApplication.run(LoginServiceProvider.class, args);
    }
}
