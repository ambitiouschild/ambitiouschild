package com.lss.SpringCloud.controller.index;

import com.lss.SpringCloud.entities.FindCategory1;
import com.lss.SpringCloud.resp.ResultData;
import com.lss.SpringCloud.service.index.FindCategory1Service;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/4/30 23:53
 * @Param:
 * @Return:
 * @Description:
 **/

@RestController
@Slf4j
public class FindCategory1Controller {

    @Resource
    private FindCategory1Service findCategory1Service;


    @PostMapping(value = "/index/findCategory1/add")
    public ResultData<String> addFindCategory1(@RequestBody FindCategory1 findCategory1) {

        System.out.println(findCategory1.toString());
        int add = findCategory1Service.add(findCategory1);
        return ResultData.success("可我不敌可爱成功插入记录，返回值" + add);

    }

    @DeleteMapping(value="/index/findCategory1/del/{id}")
    public ResultData<Integer> deleteFindCategory1(@PathVariable("id") Integer id) {

        return ResultData.success(findCategory1Service.delete(id));
    }


    @PutMapping(value = "/index/findCategory1/update")
    public ResultData<String> updateFindCategory1(@RequestBody FindCategory1 findCategory1) {

        FindCategory1 findCategory = new FindCategory1();
        BeanUtils.copyProperties(findCategory1,findCategory);
        int update = findCategory1Service.update(findCategory);
        return ResultData.success("可我不敌可爱成功修改记录，返回值：" + update);

    }

    @GetMapping(value = "/index/findCategory1/get/{id}")
    public ResultData<FindCategory1> getFindCategory1ById(@PathVariable("id") Integer id) {

        FindCategory1 i = findCategory1Service.findById(id);
        return ResultData.success(i);


    }


    @GetMapping(value = "/index/findCategory1")
    public ResultData<List<FindCategory1>> getFindCategory1All(){
        List<FindCategory1> all = findCategory1Service.findAll();

        return ResultData.success(all);

    }


}


