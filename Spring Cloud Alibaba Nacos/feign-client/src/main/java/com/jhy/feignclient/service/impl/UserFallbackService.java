package com.jhy.feignclient.service.impl;

import com.jhy.feignclient.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jihongye
 * @date: 2021/03/07/11:01
 * @description:
 */
@Service
public class UserFallbackService implements UserService {

    @Override
    public Map<String, Object> getUserById(Long id) {
        Map<String, Object> result = new HashMap<>();
        result.put("type", "ok");
        result.put("msg", "查询成功(fallback-service)");

        return result;
    }
}
