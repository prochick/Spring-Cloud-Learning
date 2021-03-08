package com.jhy.springcloudservice2.controller;

import com.jhy.springcloudcommon.entity.User;
import com.jhy.springcloudservice2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
