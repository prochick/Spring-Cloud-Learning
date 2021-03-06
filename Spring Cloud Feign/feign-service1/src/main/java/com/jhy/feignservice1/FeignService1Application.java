package com.jhy.feignservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FeignService1Application {

    public static void main(String[] args) {
        SpringApplication.run(FeignService1Application.class, args);
    }

}
