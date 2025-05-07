package com.lss.SpringCloud.service.index;

import com.lss.SpringCloud.entities.ParentCategory;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/4 14:54
 * @Param:
 * @Return:
 * @Description:
 **/
public interface ParentCategoryService {

    public List<ParentCategory> findAllWithChildrenCategories();

    public List<ParentCategory> selectAll();
}
