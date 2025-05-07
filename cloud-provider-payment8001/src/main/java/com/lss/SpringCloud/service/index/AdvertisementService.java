package com.lss.SpringCloud.service.index;

import com.lss.SpringCloud.entities.Advertisement;
import com.lss.SpringCloud.entities.Banner;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/1 0:16
 * @Param:
 * @Return:
 * @Description:
 **/
public interface AdvertisementService {


    public int add(Advertisement advertisement);
    public int update(Advertisement advertisement);
    public int delete(Integer id);
    public Advertisement findById(Integer id);
    public List<Advertisement> findAll();
}
