package com.lss.SpringCloud.controller.index;

import com.lss.SpringCloud.entities.FindCategory1;
import com.lss.SpringCloud.entities.FindListGoods;
import com.lss.SpringCloud.mapper.FindListGoodsMapper;
import com.lss.SpringCloud.resp.ResultData;
import com.lss.SpringCloud.service.index.FindListGoodsService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/1 0:50
 * @Param:
 * @Return:
 * @Description:
 **/

@RestController
@Slf4j
public class FindListGoodsController {

    @Resource
    private FindListGoodsService findListGoodsService;

    @GetMapping(value = "/index/findListGoods")
    public ResultData<List<FindListGoods>> getFindListGoodsAll() {

        List<FindListGoods> all = findListGoodsService.findAll();

        return ResultData.success(all);
    }
}