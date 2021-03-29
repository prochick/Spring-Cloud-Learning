package com.jhy.orderservice.client;

import org.springframework.stereotype.Service;

/**
 * @author: jihongye
 * @date: 2021/03/27/23:29
 * @description:
 */
@Service
public class StockFallbackClient implements StockClient{

    @Override
    public Boolean updateStock(Long itemId) {
        return false;
    }
}
