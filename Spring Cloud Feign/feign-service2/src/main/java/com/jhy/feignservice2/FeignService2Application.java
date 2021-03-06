package com.jhy.feignservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FeignService2Application {

    public static void main(String[] args) {
        SpringApplication.run(FeignService2Application.class, args);
    }

}
