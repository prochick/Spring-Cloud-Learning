package com.jhy.stockservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jhy.stockservice.dao.StockDao;
import com.jhy.stockservice.pojo.Stock;
import com.jhy.stockservice.service.StockService;
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
public class StockServiceImpl implements StockService {
    private Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

    @Autowired
    private StockDao stockDao;

    @Override
    @Transactional
    public Boolean updateStock(Long itemId) {
        UpdateWrapper<Stock> wrapper = new UpdateWrapper<>();
        wrapper.eq("item_id", itemId);
        wrapper.setSql("item_num=item_num-1");

        logger.info("---------------->修改库存开始");
        System.out.println(1/0);
        int update = stockDao.update(null, wrapper);
        logger.info("---------------->修改库存结束");

        if(update > 0){
            return true;
        }

        return false;
    }
}
