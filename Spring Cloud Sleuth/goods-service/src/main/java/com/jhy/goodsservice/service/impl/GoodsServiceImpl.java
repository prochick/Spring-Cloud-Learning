package com.jhy.goodsservice.service.impl;

import com.jhy.goodsservice.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * @author: jihongye
 * @date: 2021/03/09/20:56
 * @description:
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Override
    public Boolean updGoods() {
        System.out.println("减少库存成功！");

        return true;
    }
}
