package com.jhy.consulservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulService1Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsulService1Application.class, args);
    }

}
