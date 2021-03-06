package com.jhy.ribbonclient.controller;

import com.jhy.ribbonclient.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    private static String SERVICE_URL = "http://ribbon-service/";

    @GetMapping("/get/{id}")
    public Map<String, Object> getUser(@PathVariable Long id){
        Map result = restTemplate.getForObject(SERVICE_URL + "get/" + id, Map.class);

        return result;
    }

    @GetMapping("/add")
    public Map<String, Object> addUser(User user){
        Map result = restTemplate.postForObject(SERVICE_URL + "add", user, Map.class);

        return result;
    }
}
