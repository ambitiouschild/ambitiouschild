package com.lss.SpringCloud.service.impl;

import com.lss.SpringCloud.entities.Pay;
import com.lss.SpringCloud.mapper.PayMapper;
import com.lss.SpringCloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


//对于我们业务实现产生类必然要，全部的增删改查方法全部那下，implements 实施;执行;贯彻;使生效;
//implements是一个类实现一个接口用的关键字.实现一个接口，必须实现接口中的所有方法。


@Service
public class PayServiceImpl implements PayService {


    //servicesd调用我们的dao层
    @Resource   //idea推荐用resource
    private PayMapper payMapper; //paymapper这个接口，相当于就是我们的dao

    //对于我们mybatis的mapper作用成功了，会反馈作用成功几条，新增一条成功他会返回个1
    //insertSelective保存一个实体，null的属性不会保存，会使用数据库默认值

    //我们在建表建库的时候，创建时间和修改时间我们就会用数据库的默认值，所以对于做inser新增就用insertSelective

    //增
    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }
    //删
    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }
    //改
    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }//根据主键跟新不为null的值，自然而然会调用
    //查
    @Override
    public Pay getByID(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }
    //全查
    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
