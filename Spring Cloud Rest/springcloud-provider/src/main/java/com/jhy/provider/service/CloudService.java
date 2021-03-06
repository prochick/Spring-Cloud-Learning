package com.jhy.provider.service;

import com.jhy.pojo.Cloud;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: jihongye
 * @date: 2021/03/05/14:00
 * @description:
 */
public interface CloudService {
    int addCloud(Cloud cloud);

    Cloud getCloudById(Long id);

    List<Cloud> listClouds();
}
