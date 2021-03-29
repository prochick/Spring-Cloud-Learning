package com.jhy.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: jihongye
 * @date: 2021/03/27/23:27
 * @description:
 */
@Component
@FeignClient(value = "stock-service")
public interface StockClient {

    @PostMapping("stock/update/{itemId}")
    Boolean updateStock(@PathVariable("itemId") Long itemId);
}
