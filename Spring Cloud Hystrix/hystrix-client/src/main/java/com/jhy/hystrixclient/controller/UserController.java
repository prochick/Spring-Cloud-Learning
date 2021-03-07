package com.jhy.hystrixclient.controller;

import com.jhy.hystrixcommon.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;

    private static String SERVICE_URL = "http://hystrix-service/";

    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "getUserHystrix")
    public Map<String, Object> getUser(@PathVariable Long id){
        Map result = restTemplate.getForObject(SERVICE_URL + "get/" + id, Map.class);

        return result;
    }

    public Map<String, Object> getUserHystrix(Long id){
        User user = new User(1L,"张三","zhangsan");

        Map<String, Object> result = new HashMap<>();
        result.put("type", "ok");
        result.put("msg", "查询成功(服务降级)");
        result.put("content", user);

        return result;
    }
}
