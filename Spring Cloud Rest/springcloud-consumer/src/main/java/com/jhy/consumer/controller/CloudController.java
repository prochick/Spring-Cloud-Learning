package com.jhy.consumer.controller;

import com.jhy.pojo.Cloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: jihongye
 * @date: 2021/03/05/14:18
 * @description:
 */
@RestController
public class CloudController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/add")
    public int addCloud(Cloud cloud){
        return restTemplate.postForObject("http://localhost:8081/provider/add", cloud, Integer.class);
    }

    @GetMapping("/consumer/get/{id}")
    public Cloud getCloudById(@PathVariable("id") Long id){
        return restTemplate.getForObject("http://localhost:8081/provider/get/" + id, Cloud.class);
    }

    @GetMapping("/consumer/list")
    public List<Cloud> listClouds() {
        return restTemplate.getForObject("http://localhost:8081/provider/list/", List.class);
    }
}
