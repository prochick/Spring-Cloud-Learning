package com.jhy.springcloudclient.controller;

import com.jhy.springcloudclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: jihongye
 * @date: 2021/03/06/16:21
 * @description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/{id}")
    public Map<String, Object> getUser(@PathVariable Long id){

        return userService.getUserById(id);
    }
}
