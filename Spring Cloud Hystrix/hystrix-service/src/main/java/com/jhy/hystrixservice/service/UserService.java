package com.jhy.hystrixservice.service;

import com.jhy.hystrixcommon.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author: jihongye
 * @date: 2021/03/07/14:52
 * @description:
 */
public interface UserService {

    User getUserById(Long id);
}
