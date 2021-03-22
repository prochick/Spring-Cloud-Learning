package com.jhy.nacosservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosService1Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosService1Application.class, args);
    }

}
