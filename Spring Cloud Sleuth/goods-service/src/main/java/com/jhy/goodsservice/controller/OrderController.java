package com.jhy.goodsservice.controller;

import com.jhy.goodsservice.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jihongye
 * @date: 2021/03/09/20:56
 * @description:
 */
@RestController
public class OrderController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("goods/upd")
    public Boolean addOrder() {

        return goodsService.updGoods();
    }
}
