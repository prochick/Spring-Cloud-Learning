package com.jhy.springcloudservice2.service;

import com.jhy.springcloudcommon.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author: jihongye
 * @date: 2021/03/07/14:52
 * @description:
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public User getUserById(Long id) {
        User user = new User(1L, "张三", "zhangsan");

        return user;
    }
}
