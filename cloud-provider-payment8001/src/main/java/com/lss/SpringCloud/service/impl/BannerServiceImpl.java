package com.lss.SpringCloud.service.impl;

import com.lss.SpringCloud.entities.Banner;
import com.lss.SpringCloud.mapper.BannerMapper;
import com.lss.SpringCloud.service.index.BannerService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/4/30 20:35
 * @Param:
 * @Return:
 * @Description:
 **/

@Service
public class BannerServiceImpl implements BannerService {


    @Resource
    private BannerMapper bannerMapper;

    @Override
    public int add(Banner banner) {
        return bannerMapper.insertSelective(banner);
    }

    @Override
    public int update(Banner banner) {
        return bannerMapper.updateByPrimaryKeySelective(banner);
    }

    @Override
    public int delete(Integer id) {
        return bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Banner findById(Integer id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Banner> findAll() {
        return bannerMapper.selectAll();
    }
}
