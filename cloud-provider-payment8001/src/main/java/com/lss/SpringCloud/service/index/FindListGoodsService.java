package com.lss.SpringCloud.service.index;

import com.lss.SpringCloud.entities.FindCategory1;
import com.lss.SpringCloud.entities.FindListGoods;

import java.util.List;

/**
    *@Author: 雒世松
    *@Date: 2025/5/3 15:47
    *@Param:
    *@Return:
    *@Description:
    **/


public interface FindListGoodsService {

    public int add(FindListGoods findListGoods);
    public int update(FindListGoods findListGoods);
    public int delete(Integer id);
    public FindListGoods findById(Integer id);
    public List<FindListGoods> findAll();
}
