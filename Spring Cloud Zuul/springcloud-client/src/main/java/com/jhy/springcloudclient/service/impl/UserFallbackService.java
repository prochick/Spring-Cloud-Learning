package com.jhy.springcloudclient.service.impl;

import com.jhy.springcloudclient.service.UserService;
import com.jhy.springcloudcommon.entity.User;
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
}
