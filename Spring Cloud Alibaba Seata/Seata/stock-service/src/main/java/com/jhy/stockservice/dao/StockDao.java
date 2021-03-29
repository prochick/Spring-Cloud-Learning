package com.jhy.stockservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jhy.stockservice.pojo.Stock;
import org.springframework.stereotype.Repository;

/**
 * @author: jihongye
 * @date: 2021/03/09/20:56
 * @description:
 */
@Repository
public interface StockDao extends BaseMapper<Stock> {

}
