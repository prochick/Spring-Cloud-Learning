package com.jhy.hystrixservice.service;

import com.jhy.hystrixcommon.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * @author: jihongye
 * @date: 2021/03/07/14:52
 * @description:
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    @HystrixCommand(fallbackMethod = "getUserByIdBreak")
    public User getUserById(Long id) {
        User user = null;
        if(id > 0 && id <= 10){
            user = new User(1L, "张三", "zhangsan");
        }else{
            throw new RuntimeException("未找到此用户");
        }

        return user;
    }

    public User getUserByIdBreak(Long id) {
        User user = new User(1L, "默认", "默认");;

        return user;
    }
}
