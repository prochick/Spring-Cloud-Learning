package com.jhy.orderservice.service.impl;

import com.jhy.orderservice.service.GoodsService;
import com.jhy.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: jihongye
 * @date: 2021/03/09/20:56
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    GoodsService goodsService;

    @Override
    public Boolean addOrder() {
        System.out.println("添加订单成功！");
        Boolean flag = goodsService.updGoods();

        return flag;
    }
}
