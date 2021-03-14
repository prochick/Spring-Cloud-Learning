package com.jhy.consulgateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author: jihongye
 * @date: 2021/03/13/15:35
 * @description:
 */
@Configuration
public class CustomRouteFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("进入自定义过滤器");

        if(exchange.getRequest().getQueryParams().get("user") != null){
            System.out.println("验证成功！");

            return chain.filter(exchange);
        }else{
            System.out.println("验证失败！");

            return exchange.getResponse().setComplete();
        }
    }

    /**
     * 路由执行顺序（值越小越先执行）
     * @return
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
