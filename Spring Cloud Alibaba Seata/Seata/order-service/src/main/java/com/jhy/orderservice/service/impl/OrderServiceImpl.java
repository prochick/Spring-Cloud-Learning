package com.jhy.orderservice.service.impl;

import com.jhy.orderservice.client.StockClient;
import com.jhy.orderservice.dao.OrderDao;
import com.jhy.orderservice.pojo.Order;
import com.jhy.orderservice.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: jihongye
 * @date: 2021/03/09/20:56
 * @description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StockClient stockClient;

    @Override
    @GlobalTransactional
    public Boolean addOrder(Order order) {
        logger.info("----------------->下订单业务开始");

        // 插入订单
        orderDao.insert(order);
        // 减少库存
        stockClient.updateStock(order.getItemId());

        logger.info("----------------->下订单业务结束");

        return true;
    }
}
