package com.lss.SpringCloud.entities;

import javax.persistence.*;

/**
 * 表名：findcategorytree
*/
@Table(name = "findcategorytree")
public class FindCategoryTree {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "categoryList")
    private String categorylist;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return categorylist
     */
    public String getCategorylist() {
        return categorylist;
    }

    /**
     * @param categorylist
     */
    public void setCategorylist(String categorylist) {
        this.categorylist = categorylist;
    }
}