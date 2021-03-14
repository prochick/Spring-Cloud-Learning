package com.jhy.consulservice1.controller;

import com.jhy.consulservice1.entity.User;
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

    @GetMapping("/get/{id}")
    public Map<String, Object> getUser(@PathVariable Long id) {
        User user = new User(1L, "张三", "zhangsan");

        Map<String, Object> result = new HashMap<>();
        result.put("type", "ok");
        result.put("msg", "查询成功(service1)");
        result.put("content", user);

        return result;
    }

    @PostMapping("/add")
    public Map<String, Object> addUser(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        result.put("type", "ok");
        result.put("msg", "添加成功");
        result.put("content", user);

        return result;
    }
}
