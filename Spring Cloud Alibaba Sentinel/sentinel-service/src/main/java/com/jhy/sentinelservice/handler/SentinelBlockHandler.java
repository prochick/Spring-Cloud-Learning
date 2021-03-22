package com.jhy.sentinelservice.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;

/**
 * @author: jihongye
 * @date: 2021/03/22/21:16
 * @description:
 */
public class SentinelBlockHandler {

    public String myBlockHandler(Long id, BlockException blockException){
        if(blockException instanceof FlowException){
            return "test1不可达,出现限流！";
        }
        if(blockException instanceof DegradeException){
            return "test1不可达,出现熔断！";
        }

        return "test1不可达,出现其它异常！";
    }
}
