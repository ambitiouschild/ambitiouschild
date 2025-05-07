package com.lss.SpringCloud.service.index;

import com.lss.SpringCloud.entities.FindListGoods;
import com.lss.SpringCloud.entities.FindRecommendGoods;
import com.lss.SpringCloud.resp.ResultData;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/1 14:41
 * @Param:
 * @Return:
 * @Description:
 **/
public interface FindRecommendGoodsService {


    public int add(FindRecommendGoods findRecommendGoods);
    public int update(FindRecommendGoods findRecommendGoods);
    public int delete(Integer id);
    public FindRecommendGoods findById(Integer id);
    public List<FindRecommendGoods> findAll();

}
