package com.jhy.ribbonservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RibbonService2Application {

    public static void main(String[] args) {
        SpringApplication.run(RibbonService2Application.class, args);
    }

}
