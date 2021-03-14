package com.jhy.configclient2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jihongye
 * @date: 2021/03/13/21:54
 * @description:
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${name}")
    private String name;

    @GetMapping("/configInfo")
    public String getConfigInfo() {

        return name;
    }
}
