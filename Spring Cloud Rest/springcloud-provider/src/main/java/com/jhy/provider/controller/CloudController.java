package com.jhy.provider.controller;

import com.jhy.pojo.Cloud;
import com.jhy.provider.service.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: jihongye
 * @date: 2021/03/05/14:01
 * @description:
 */
@RestController
public class CloudController {

    @Autowired
    private CloudService cloudService;

    @PostMapping("/provider/add")
    public int addCloud(@RequestBody Cloud cloud){
        return cloudService.addCloud(cloud);
    }

    @GetMapping("/provider/get/{id}")
    public Cloud getCloudById(@PathVariable("id") Long id){
        return cloudService.getCloudById(id);
    }

    @GetMapping("/provider/list")
    public List<Cloud> listClouds() {
        return cloudService.listClouds();
    }
}
