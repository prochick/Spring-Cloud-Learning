package com.jhy.ribbonservice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RibbonService3Application {

    public static void main(String[] args) {
        SpringApplication.run(RibbonService3Application.class, args);
    }

}
