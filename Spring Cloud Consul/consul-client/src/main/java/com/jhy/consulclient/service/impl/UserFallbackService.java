package com.jhy.consulclient.service.impl;

import com.jhy.consulclient.entity.User;
import com.jhy.consulclient.service.UserService;
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
        User user = new User(1L, "张三", "zhangsan");

        Map<String, Object> result = new HashMap<>();
        result.put("type", "ok");
        result.put("msg", "查询成功(fallback-service)");
        result.put("content", user);

        return result;
    }

    @Override
    public Map<String, Object> addUser(User user) {
        Map<String, Object> result = new HashMap<>();

        result.put("type", "ok");
        result.put("msg", "添加成功(fallback-service)");
        result.put("content", user);

        return result;
    }
}
