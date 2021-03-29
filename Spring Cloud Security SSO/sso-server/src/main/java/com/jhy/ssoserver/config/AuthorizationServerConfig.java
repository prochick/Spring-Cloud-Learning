package com.jhy.ssoserver.config;

import com.jhy.ssoserver.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @author: jihongye
 * @date: 2021/03/25/15:45
 * @description: 认证授权服务
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServiceImpl userDetailsService;

    @Autowired
    @Qualifier("jwtTokenStore")
    private TokenStore tokenStore;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    /**
     * 使用密码模式所需置
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .tokenStore(tokenStore)
                .accessTokenConverter(jwtAccessTokenConverter);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin") //配置client_id
                .secret(passwordEncoder.encode("admin123456")) //配置client_secret
                .accessTokenValiditySeconds(3600) //配置访问token的有效期
                .refreshTokenValiditySeconds(864000) //配置刷新token的有效期
                .redirectUris("http://127.0.0.1:8082/login") //配置redirect_uri，用于授权成功后跳转
                .autoApprove(true)
                .scopes("all") //配置申请的权限范围
                .authorizedGrantTypes("authorization_code", "password", "refresh_token"); //配置grant_type，表示授权类型
    }

    /**
     * 获取密钥需要身份认证，使用单点登录时必须配置
     * @param security
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {

        security.tokenKeyAccess("isAuthenticated()");
    }
}