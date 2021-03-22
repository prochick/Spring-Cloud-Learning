package com.jhy.nacosconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jihongye
 * @date: 2021/03/21/12:01
 * @description:
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${name}")
    private String name;

    @GetMapping("/configInfo")
    public String getConfigInfo() {

        return name;
    }
}
