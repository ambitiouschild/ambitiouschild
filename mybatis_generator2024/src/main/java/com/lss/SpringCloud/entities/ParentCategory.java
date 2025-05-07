package com.lss.SpringCloud.entities;

import javax.persistence.*;

/**
 * 表名：parentcategory
*/
@Table(name = "parentcategory")
public class ParentCategory {
    @Id
    private Integer categorylistid;

    private String categorylist;

    /**
     * @return categorylistid
     */
    public Integer getCategorylistid() {
        return categorylistid;
    }

    /**
     * @param categorylistid
     */
    public void setCategorylistid(Integer categorylistid) {
        this.categorylistid = categorylistid;
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