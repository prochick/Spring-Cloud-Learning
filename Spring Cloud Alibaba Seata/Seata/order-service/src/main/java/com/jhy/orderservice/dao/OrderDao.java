package com.jhy.orderservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jhy.orderservice.pojo.Order;
import org.springframework.stereotype.Repository;

/**
 * @author: jihongye
 * @date: 2021/03/09/20:56
 * @description:
 */
@Repository
public interface OrderDao extends BaseMapper<Order> {

}
