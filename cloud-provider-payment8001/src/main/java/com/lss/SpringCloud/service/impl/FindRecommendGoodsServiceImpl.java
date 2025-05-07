package com.lss.SpringCloud.service.impl;

import com.lss.SpringCloud.entities.FindRecommendGoods;
import com.lss.SpringCloud.mapper.FindRecommendGoodsMapper;
import com.lss.SpringCloud.service.index.FindListGoodsService;
import com.lss.SpringCloud.service.index.FindRecommendGoodsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/1 14:44
 * @Param:
 * @Return:
 * @Description:
 **/

@Service
public class FindRecommendGoodsServiceImpl implements FindRecommendGoodsService {

    @Resource
    private FindRecommendGoodsMapper findRecommendGoodsMapper;


    @Override
    public int add(FindRecommendGoods findListGoods) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int update(FindRecommendGoods findListGoods) {
        return 0;
    }

    @Override
    public FindRecommendGoods findById(Integer id) {
        return null;
    }

    @Override
    public List<FindRecommendGoods> findAll() {
        return findRecommendGoodsMapper.selectAll();
    }
}
