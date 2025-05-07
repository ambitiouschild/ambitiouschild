package com.lss.SpringCloud.mapper;

import com.lss.SpringCloud.entities.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/4 13:26
 * @Param:
 * @Return:
 * @Description:
 **/
public interface ParentCategoryRepository extends JpaRepository<ParentCategory, Integer> {

    // 使用JOIN FETCH避免N+1查询问题

    //SELECT DISTINCT fc: 这里使用了DISTINCT关键字来确保查询结果中不会有重复的ParentCategory实体。
    // 这对于避免一对多关系中的重复父实体很有用。
    //
    //LEFT JOIN FETCH fc.Children: 这个部分使用了LEFT JOIN FETCH来优化性能。LEFT JOIN FETCH会立即加载关联的子实体（Children），
    // 这样可以减少后续的数据库访问，提高效率。这对于懒加载和立即加载的区别非常重要。

    //DISTINCT 的作用:当父分类有多个子分类时，LEFT JOIN 会导致结果集中父分类重复出现（每个子分类对应一行）。
    //DISTINCT 关键字用于去重，确保返回的父分类列表唯一。
    @Query("SELECT DISTINCT l FROM ParentCategory l LEFT JOIN FETCH l.ChildrenCategory")
    List<ParentCategory> findAllWithSecondCategories();
}
