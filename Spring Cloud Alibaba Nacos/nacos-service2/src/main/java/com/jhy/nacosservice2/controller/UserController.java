package com.jhy.nacosservice2.controller;

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
        Map<String, Object> result = new HashMap<>();
        result.put("type", "ok");
        result.put("msg", "查询成功(service2)");

        return result;
    }
}
