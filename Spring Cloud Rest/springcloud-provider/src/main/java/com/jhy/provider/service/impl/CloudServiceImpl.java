package com.jhy.provider.service.impl;

import com.jhy.pojo.Cloud;
import com.jhy.provider.dao.CloudDao;
import com.jhy.provider.service.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jihongye
 * @date: 2021/03/05/14:00
 * @description:
 */
@Service
public class CloudServiceImpl implements CloudService {

    @Autowired
    private CloudDao cloudDao;

    @Override
    public int addCloud(Cloud cloud) {
        return cloudDao.addCloud(cloud);
    }

    @Override
    public Cloud getCloudById(Long id) {
        return cloudDao.getCloudById(id);
    }

    @Override
    public List<Cloud> listClouds() {
        return cloudDao.listClouds();
    }
}
