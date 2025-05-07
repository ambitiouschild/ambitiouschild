package com.lss.SpringCloud.entities;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * 表名：parentcategory
*/
@Table(name = "parentcategory")
public class ParentCategory {
    @Id
    private Integer categoryListId;

    private String categoryList;


    private List<ChildrenCategory> childCategories; // 包含子分类集合


    /**
     * @return categoryListId
     */
    public Integer getCategoryListId() {
        return categoryListId;
    }

    /**
     * @param categoryListId
     */
    public void setCategoryListId(Integer categoryListId) {
        this.categoryListId = categoryListId;
    }

    /**
     * @return categoryList
     */
    public String getCategoryList() {
        return categoryList;
    }

    /**
     * @param categoryList
     */
    public void setCategoryList(String categoryList) {
        this.categoryList = categoryList;
    }

    public List<ChildrenCategory> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<ChildrenCategory> childCategories) {
        this.childCategories = childCategories;
    }
}