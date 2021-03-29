package com.jhy.stockservice.controller;

import com.jhy.stockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    private StockService stockService;

    @PostMapping("stock/update/{itemId}")
    public Boolean updateStock(@PathVariable("itemId") Long itemId){

        return stockService.updateStock(itemId);
    }
}
