package com.jhy.zuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jihongye
 * @date: 2021/03/14/17:16
 * @description:
 */
@Component
@Primary
public class SwaggerConfig implements SwaggerResourcesProvider {

    @Autowired
    RouteLocator routeLocator;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<Route> routes = routeLocator.getRoutes();

        // 获取所有路由信息
        for (Route route : routes) {
            resources.add(swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs")));
        }

        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {
        System.out.printf("name:%s, location:%s\n", name, location);

        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }
}
