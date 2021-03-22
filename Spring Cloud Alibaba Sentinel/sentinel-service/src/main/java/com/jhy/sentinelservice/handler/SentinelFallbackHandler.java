package com.jhy.sentinelservice.handler;

/**
 * @author: jihongye
 * @date: 2021/03/22/21:16
 * @description:
 */
public class SentinelFallbackHandler {

    public String myFallback(Long id){

        return "test1不可达,出现内部调用异常！";
    }
}
