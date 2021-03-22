package com.jhy.ribbonclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jihongye
 * @date: 2021/03/21/14:26
 * @description:
 */
@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public List<Object> getServices(){
        List<Object> list = new ArrayList<>();

        List<ServiceInstance> instances = discoveryClient.getInstances("nacos-service");
        for (ServiceInstance instance : instances) {
            list.add(instance.getUri());
        }

        return list;
    }
}
