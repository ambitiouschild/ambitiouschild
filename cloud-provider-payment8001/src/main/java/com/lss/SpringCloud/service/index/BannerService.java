package com.lss.SpringCloud.service.index;

import com.lss.SpringCloud.entities.Banner;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/4/30 20:33
 * @Param:
 * @Return:
 * @Description:
 **/
public interface BannerService {



    public int add(Banner banner);
    public int update(Banner banner);
    public int delete(Integer id);
    public Banner findById(Integer id);
    public List<Banner> findAll();

}
