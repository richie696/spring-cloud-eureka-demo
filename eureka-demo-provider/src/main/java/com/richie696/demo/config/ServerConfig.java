package com.richie696.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "my-server")
public class ServerConfig {

    private Integer datacenterId;

    private Integer machineId;

    public Integer getDatacenterId() {
        return datacenterId;
    }

    public ServerConfig setDatacenterId(Integer datacenterId) {
        this.datacenterId = datacenterId;
        return this;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public ServerConfig setMachineId(Integer machineId) {
        this.machineId = machineId;
        return this;
    }
}
