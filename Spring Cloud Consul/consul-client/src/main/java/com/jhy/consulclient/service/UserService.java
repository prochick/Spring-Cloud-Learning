package com.jhy.consulclient.service;

import com.jhy.consulclient.entity.User;
import com.jhy.consulclient.service.impl.UserFallbackService;
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
@FeignClient(value = "consul-service", fallback = UserFallbackService.class)
public interface UserService {

    @GetMapping("/get/{id}")
    Map<String, Object> getUserById(@PathVariable Long id);

    @PostMapping("/add")
    Map<String, Object> addUser(@RequestBody User user);
}
