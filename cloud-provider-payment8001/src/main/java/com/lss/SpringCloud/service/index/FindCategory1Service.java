package com.lss.SpringCloud.service.index;

import com.lss.SpringCloud.entities.FindCategory1;
import com.lss.SpringCloud.resp.ResultData;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/4/30 23:37
 * @Param:
 * @Return:
 * @Description:
 **/
public interface FindCategory1Service {

    public int add(FindCategory1 findCategory1);
    public int update(FindCategory1 findCategory1);
    public int delete(Integer id);
    public FindCategory1 findById(Integer id);
    public List<FindCategory1> findAll();
}
