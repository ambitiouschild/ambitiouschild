package com.lss.SpringCloud.service;

import com.lss.SpringCloud.entities.Pay;

import java.util.List;






//传统的经典操作：增删改查
//封装接口：增删改查
public interface PayService {


    public int add(Pay pay);  //增
    public int delete(Integer id); //删
    public int update(Pay pay);  //改

    public  Pay getByID(Integer id);  //查:按主键来查

    public List<Pay>  getAll(); //全查
}
