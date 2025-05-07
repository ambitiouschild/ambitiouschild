package com.lss.SpringCloud.service;

import com.lss.SpringCloud.entities.ParentCategory;
import com.lss.SpringCloud.mapper.ParentCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/4 13:29
 * @Param:
 * @Return:
 * @Description:
 **/

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final ParentCategoryRepository parentCategoryRepository;

    public List<ParentCategory> getAllCategories() {
        return parentCategoryRepository.findAllWithSecondCategories();
    }
}
