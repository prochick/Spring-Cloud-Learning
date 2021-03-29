package com.jhy.teacherservice.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

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
        docket.select().apis(RequestHandlerSelectors.basePackage("com.jhy.teacherservice.controller")).build();
        docket.select().paths(PathSelectors.any()).build();

        return docket;
    }

    /**
     * 文档基础信息
     * @return
     */
    public ApiInfo apiInfo(){
        Contact contact = new Contact("prochick", "http://www.prochick.com", "2916965025@qq.com");
        ApiInfo apiInfo = new ApiInfo(
                "Teacher微服务的Swagger文档",
                "这是Teacher微服务项目的接口文档",
                "v1.0",
                "http://www.prochick.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );

        return apiInfo;
    }
}
