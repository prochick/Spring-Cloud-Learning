package com.jhy.hystrixservice.controller;

import com.jhy.hystrixcommon.entity.User;
import com.jhy.hystrixservice.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public Map<String, Object> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);

        Map<String, Object> result = new HashMap<>();
        result.put("type", "ok");
        result.put("msg", "查询成功");
        result.put("content", user);

        return result;
    }

}
