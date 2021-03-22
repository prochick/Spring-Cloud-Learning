package com.jhy.orderservice.controller;

import com.jhy.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("order/add")
    public Boolean addOrder() {
        return orderService.addOrder();
    }
}
