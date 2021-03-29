package com.jhy.orderservice.controller;

import com.jhy.orderservice.pojo.Order;
import com.jhy.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jihongye
 * @date: 2021/03/09/20:56
 * @description:
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("order/add")
    public Boolean addUser(@RequestBody Order order) {
        return orderService.addOrder(order);
    }
}
