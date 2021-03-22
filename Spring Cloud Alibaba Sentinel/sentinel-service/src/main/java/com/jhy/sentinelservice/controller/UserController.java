package com.jhy.sentinelservice.controller;

import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.jhy.sentinelservice.handler.SentinelBlockHandler;
import com.jhy.sentinelservice.handler.SentinelFallbackHandler;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jihongye
 * @date: 2021/03/06/16:21
 * @description:
 */
@RestController
public class UserController {

    /**
     * 正常访问测试
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Map<String, Object> getUser(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        result.put("type", "ok");
        result.put("msg", "查询成功");

        return result;
    }

    /**
     * 异常访问测试
     * @param id
     * @return
     */
    @GetMapping("/show/test1")
    @SentinelResource(
            value = "test1",
            blockHandler = "myBlockHandler",
            blockHandlerClass = SentinelBlockHandler.class,
            fallback = "myFallback",
            fallbackClass = SentinelFallbackHandler.class
    )
    public String test1(Long id) {
        System.out.println(1/0);

        return "test1调用成功";
    }
}
