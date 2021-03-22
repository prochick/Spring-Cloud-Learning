package com.jhy.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: jihongye
 * @date: 2021/03/11/11:43
 * @description:
 */
@FeignClient(value = "goods-service")
public interface GoodsService{

    @PostMapping("goods/upd")
    public Boolean updGoods();
}
