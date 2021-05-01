package com.richie696.demo.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/lb")
public class LoadBalanceController {

    private final RestTemplate restTemplate;

    @Autowired
    public LoadBalanceController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/login/{name}/{password}")
    public String login(@PathVariable String name, @PathVariable String password) {
        String url = String.format("http://login-service-provider/account/login/%s/%s", name, password);
        // 调用远程服务并返回结果
        return restTemplate.getForObject(url, String.class);
    }
}
