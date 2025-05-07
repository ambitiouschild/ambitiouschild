package com.lss.SpringCloud.controller.index;

import com.lss.SpringCloud.entities.FindListGoods;
import com.lss.SpringCloud.entities.FindRecommendGoods;
import com.lss.SpringCloud.resp.ResultData;
import com.lss.SpringCloud.service.index.FindListGoodsService;
import com.lss.SpringCloud.service.index.FindRecommendGoodsService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/1 15:24
 * @Param:
 * @Return:
 * @Description:
 **/

@RestController
@Slf4j
public class FindRecommendGoodsController {

    @Resource
    private FindRecommendGoodsService findRecommendGoodsService;

    @GetMapping(value = "/index/findRecommendGoods")
    public ResultData<List<FindRecommendGoods>> getFindRecommendGoodsAll() {

        List<FindRecommendGoods> all = findRecommendGoodsService.findAll();

        return ResultData.success(all);
    }
}
