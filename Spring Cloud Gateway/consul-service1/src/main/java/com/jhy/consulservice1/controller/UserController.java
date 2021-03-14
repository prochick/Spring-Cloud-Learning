package com.jhy.consulservice1.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author: jihongye
 * @date: 2021/03/06/16:21
 * @description:
 */
@RestController
@RequestMapping("/service1")
public class UserController {

    @GetMapping("/show")
    public String show() {

        return "service1";
    }
}
