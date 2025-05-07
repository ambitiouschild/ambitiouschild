package com.lss.SpringCloud.service.impl;

import com.lss.SpringCloud.entities.Advertisement;
import com.lss.SpringCloud.mapper.AdvertisementMapper;
import com.lss.SpringCloud.service.index.AdvertisementService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/1 0:17
 * @Param:
 * @Return:
 * @Description:
 **/


@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Resource
    private AdvertisementMapper advertisementMapper;

    @Override
    public int add(Advertisement advertisement) {
        return 0;
    }

    @Override
    public int update(Advertisement advertisement) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public Advertisement findById(Integer id) {
        return null;
    }

    @Override
    public List<Advertisement> findAll() {
        return advertisementMapper.selectAll();
    }
}
