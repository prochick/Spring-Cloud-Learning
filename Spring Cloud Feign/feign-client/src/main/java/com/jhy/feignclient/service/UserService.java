package com.jhy.feignclient.service;

import com.jhy.feigncommon.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author: jihongye
 * @date: 2021/03/06/23:11
 * @description:
 */
@Component
@FeignClient(value = "feign-service")
public interface UserService {

    @GetMapping("/get/{id}")
    Map<String, Object> getUserById(@PathVariable Long id);

    @PostMapping("/add")
    Map<String, Object> addUser(@RequestBody User user);
}
