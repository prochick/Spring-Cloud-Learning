package com.jhy.ribbonrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: jihongye
 * @date: 2021/03/06/18:34
 * @description:
 */
@Configuration
public class RuleConfig {

    @Bean
    public IRule myRule(){
        return new MyRule();
    }
}
