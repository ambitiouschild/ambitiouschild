package com.lss.SpringCloud.mapper;

import com.lss.SpringCloud.entities.ChildrenCategory;
import com.lss.SpringCloud.entities.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: 雒世松
 * @Date: 2025/5/4 13:45
 * @Param:
 * @Return:
 * @Description:
 **/
public interface ChildrenCategoryRepository extends JpaRepository<ChildrenCategory, Integer> {
}
