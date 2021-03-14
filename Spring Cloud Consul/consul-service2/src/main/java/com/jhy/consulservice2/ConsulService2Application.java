package com.jhy.consulservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class ConsulService2Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsulService2Application.class, args);
    }

}
