package com.jhy.springcloudsecurityoauth2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jihongye
 * @date: 2021/03/25/16:22
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/info")
    public Object getUserInfo(Authentication authentication) {

        return authentication.getPrincipal();
    }
}
