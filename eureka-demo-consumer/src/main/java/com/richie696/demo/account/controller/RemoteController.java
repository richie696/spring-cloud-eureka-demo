package com.richie696.demo.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/remote")
public class RemoteController {

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    @Autowired
    public RemoteController(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/login/{name}/{password}")
    public String login(@PathVariable String name, @PathVariable String password) {
        // 从Eureka注册中心中根据服务提供者的名称获取服务主机的元数据信息列表
        List<ServiceInstance> instances = discoveryClient.getInstances("LOGIN-SERVICE-PROVIDER");
        // 如果当前没有可用列表则终止执行
        if (instances.isEmpty()) {
            return "当前无可用服务。";
        }
        /*
            否则获取一个实例（这里先不用负载均衡，我们后续
            会将该案例逐步升级，一步步告诉你为什么要这么做，
            我们现在就从最简单的代码开始）
         */
        ServiceInstance serviceInstance = instances.get(0);
        // 生成服务提供者实例的主机地址
        String hostName = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = String.format("http://%s:%s/account/login/%s/%s", hostName, port, name, password);
        System.out.printf("# 主机地址: %s%n", url);
        // 调用远程服务并返回结果
        return restTemplate.getForObject(url, String.class);
    }

}
