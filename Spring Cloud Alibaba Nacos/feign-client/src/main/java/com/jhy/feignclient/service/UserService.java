package com.jhy.feignclient.service;

import com.jhy.feignclient.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * @author: jihongye
 * @date: 2021/03/06/23:11
 * @description:
 */
@Component
@FeignClient(value = "nacos-service", fallback = UserFallbackService.class)
public interface UserService {

    @GetMapping("/get/{id}")
    Map<String, Object> getUserById(@PathVariable Long id);
}
