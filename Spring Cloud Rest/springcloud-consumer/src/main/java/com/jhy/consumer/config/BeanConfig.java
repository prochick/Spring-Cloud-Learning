package com.jhy.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: jihongye
 * @date: 2021/03/05/14:16
 * @description:
 */
@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}
