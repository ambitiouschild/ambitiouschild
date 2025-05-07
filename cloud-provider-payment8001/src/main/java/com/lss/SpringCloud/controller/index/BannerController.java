package com.lss.SpringCloud.controller.index;

import com.lss.SpringCloud.entities.Banner;
import com.lss.SpringCloud.resp.ResultData;
import com.lss.SpringCloud.service.index.BannerService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/4/30 20:40
 * @Param:
 * @Return:
 * @Description:
 **/
@RestController
@Slf4j
public class BannerController {

    @Resource
    private BannerService bannerService;


    @PostMapping(value = "/banner/add")
    public ResultData<String> addBanner(@RequestBody Banner banner) {

        System.out.println(banner.toString());
        int add = bannerService.add(banner);
        return ResultData.success("可我不敌可爱成功插入记录，返回值" + add);

    }

    @DeleteMapping(value="/banner/del/{id}")
    public ResultData<Integer> deleteBanner(@PathVariable("id") Integer id) {

        return ResultData.success(bannerService.delete(id));
    }


    @PutMapping(value = "/banner/update")
    public ResultData<String> updateBanner(@RequestBody Banner banner) {

        Banner banner1 = new Banner();
        BeanUtils.copyProperties(banner,banner1);
        int update = bannerService.update(banner1);
        return ResultData.success("可我不敌可爱成功修改记录，返回值：" + update);

    }

    @GetMapping(value = "/banner/get/{id}")
    public ResultData<Banner> getBannerById(@PathVariable("id") Integer id) {

        Banner i = bannerService.findById(id);
        return ResultData.success(i);


    }


    @GetMapping(value = "/index/findBanner")
    public ResultData<List<Banner>> getAll(){

        List<Banner> all = bannerService.findAll();
        return ResultData.success(all);

    }


}
