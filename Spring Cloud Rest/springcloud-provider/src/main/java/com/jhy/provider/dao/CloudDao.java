package com.jhy.provider.dao;

import com.jhy.pojo.Cloud;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: jihongye
 * @date: 2021/03/05/13:59
 * @description:
 */
@Repository
@Mapper
public interface CloudDao {

    int addCloud(Cloud cloud);

    @Select("select * from cloud where id = #{id}")
    Cloud getCloudById(@Param("id") Long id);

    @Select("select * from cloud")
    List<Cloud> listClouds();
}
