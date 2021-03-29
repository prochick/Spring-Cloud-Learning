package com.jhy.studentservice.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableKnife4j
@PropertySource("classpath:/application.yml")
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    /**
     * 获取当前SpringBoot运行环境
     */
    @Value("${spring.profiles.active}")
    private String env;

    @Bean
    public Docket docket(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        // 设置在开发环境中启用
        if(this.env.equals("dev")){
            docket.enable(true);
        }else {
            docket.enable(false);
        }

        // 设置信息
        docket.apiInfo(apiInfo());

        // 扫描接口
        docket.select().apis(RequestHandlerSelectors.basePackage("com.jhy.studentservice.controller")).build();
        docket.select().paths(PathSelectors.any()).build();

        // 安全认证
//        docket.securityContexts(Lists.newArrayList(securityContext(),securityContext1()))
//                .securitySchemes(Lists.<SecurityScheme>newArrayList(apiKey(),apiKey1()));

        return docket;
    }

    /**
     * 文档基础信息
     * @return
     */
    public ApiInfo apiInfo(){
        Contact contact = new Contact("prochick", "http://www.prochick.com", "2916965025@qq.com");
        ApiInfo apiInfo = new ApiInfo(
                "Student微服务的Swagger文档",
                "这是Student微服务项目的接口文档",
                "v1.0",
                "http://www.prochick.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );

        return apiInfo;
    }


    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }
    private ApiKey apiKey1() {
        return new ApiKey("BearerToken1", "Authorization-x", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }
    private SecurityContext securityContext1() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth1())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }
    List<SecurityReference> defaultAuth1() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken1", authorizationScopes));
    }
}
