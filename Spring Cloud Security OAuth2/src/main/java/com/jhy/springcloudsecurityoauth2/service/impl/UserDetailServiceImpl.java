package com.jhy.springcloudsecurityoauth2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: jihongye
 * @date: 2021/03/25/15:35
 * @description:
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private List<User> userList;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 初始化数据
     */
    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");

        userList = new ArrayList<>();
        userList.add(new User("admin", password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
        userList.add(new User("zhangsan", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        userList.add(new User("lisi", password, AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> findUserList = userList.stream()
                .filter(user -> user.getUsername().equals(username))
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(findUserList)) {
            return findUserList.get(0);
        } else {
            throw new UsernameNotFoundException("用户名不存在！");
        }
    }
}
