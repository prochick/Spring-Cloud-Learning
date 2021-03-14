package com.jhy.userservice2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jihongye
 * @date: 2021/03/06/16:21
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/show")
    public String show() {

        return "user-service2";
    }
}
