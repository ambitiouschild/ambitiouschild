package com.lss.SpringCloud.controller;

import com.lss.SpringCloud.entities.ParentCategory;
import com.lss.SpringCloud.service.CategoryService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 雒世松
 * @Date: 2025/5/4 13:30
 * @Param:
 * @Return:
 * @Description:
 **/

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {


    @Resource
    private final CategoryService categoryService;

    // 直接返回实体
    @GetMapping
    public ResponseEntity<List<ParentCategory>> getAll() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }





}
