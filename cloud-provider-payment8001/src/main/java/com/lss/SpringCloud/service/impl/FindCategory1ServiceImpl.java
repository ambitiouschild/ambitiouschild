package com.lss.SpringCloud.service.impl;

import com.lss.SpringCloud.entities.FindCategory1;
import com.lss.SpringCloud.mapper.FindCategory1Mapper;
import com.lss.SpringCloud.resp.ResultData;
import com.lss.SpringCloud.service.index.FindCategory1Service;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/4/30 23:38
 * @Param:
 * @Return:
 * @Description:
 **/

@Service
public class FindCategory1ServiceImpl implements FindCategory1Service {


    @Resource
    private FindCategory1Mapper findCategory1Mapper;


    @Override
    public int add(FindCategory1 findCategory1) {
        return findCategory1Mapper.insert(findCategory1);
    }

    @Override
    public int update(FindCategory1 findCategory1) {
        return findCategory1Mapper.updateByPrimaryKeySelective(findCategory1);
    }

    @Override
    public int delete(Integer id) {
        return findCategory1Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public FindCategory1 findById(Integer id) {
        return findCategory1Mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<FindCategory1> findAll() {

        return findCategory1Mapper.selectAll();
    }
}
