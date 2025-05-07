package com.lss.SpringCloud.controller.index;

import com.lss.SpringCloud.entities.Advertisement;
import com.lss.SpringCloud.entities.Banner;
import com.lss.SpringCloud.entities.FindCategory1;
import com.lss.SpringCloud.mapper.AdvertisementMapper;
import com.lss.SpringCloud.resp.ResultData;
import com.lss.SpringCloud.service.index.AdvertisementService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/1 0:22
 * @Param:
 * @Return:
 * @Description:
 **/

@RestController
@Slf4j
public class AdvertisementController {

    @Resource
    private AdvertisementService advertisementService;

    @GetMapping(value = "/index/advertisement")
    public ResultData<List<Advertisement>> getAdvertisementAll(){

        List<Advertisement> all =  advertisementService.findAll();
        return ResultData.success(all);

    }
}
