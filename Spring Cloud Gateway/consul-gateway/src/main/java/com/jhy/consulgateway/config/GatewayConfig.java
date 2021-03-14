package com.jhy.consulgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: jihongye
 * @date: 2021/03/13/14:19
 * @description:
 */
@Configuration
public class GatewayConfig {

    /**
     * 路由配置
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(
//                        "consul-service1",
//                        r -> r.path("/service1/**").uri("http://localhost:8081/")
//                )
//                .route(
//                        "consul-service2",
//                        r -> r.path("/service2/**").uri("http://localhost:8082/")
//                )
//                .build();
//    }
}
