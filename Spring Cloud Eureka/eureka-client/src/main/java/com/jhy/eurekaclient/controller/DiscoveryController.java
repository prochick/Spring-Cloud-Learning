package com.jhy.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: jihongye
 * @date: 2021/03/06/12:11
 * @description:
 */
@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Object discovery(){
        // 获取微服务列表的清单
        List<String> services = discoveryClient.getServices();

        // 得到每一个微服务的信息, 通过具体的微服务ID或ApplicationName
        for (String service : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(service.toUpperCase());
            for (ServiceInstance instance : instances) {
                System.out.println(
                        instance.getHost()+"\t"+
                                instance.getPort()+"\t"+
                                instance.getUri()+"\t"+
                                instance.getServiceId()
                );
            }
        }

        return this.discoveryClient;
    }
}
