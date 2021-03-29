package com.jhy.ssoclient.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jihongye
 * @date: 2021/03/25/21:27
 * @description:
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("/info")
    public Object getCurrentUser(Authentication authentication) {

        return authentication;
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/msg")
    public String getMessage(){
        return "您拥有admin权限, 可以访问！";
    }
}
