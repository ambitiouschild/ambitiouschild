package com.lss.SpringCloud.service.impl;

import com.lss.SpringCloud.entities.FindListGoods;
import com.lss.SpringCloud.entities.FindRecommendGoods;
import com.lss.SpringCloud.mapper.FindListGoodsMapper;
import com.lss.SpringCloud.service.index.FindListGoodsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/1 0:49
 * @Param:
 * @Return:
 * @Description:
 **/
@Service
public class FindListGoodsServiceImpl implements FindListGoodsService {

    @Resource
    private FindListGoodsMapper findListGoodsMapper;


    @Override
    public int add(FindListGoods findListGoods) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public FindListGoods findById(Integer id) {
        return null;
    }

    @Override
    public int update(FindListGoods findListGoods) {
        return 0;
    }


    @Override
    public List<FindListGoods> findAll() {
        return findListGoodsMapper.selectAll();
    }
}
