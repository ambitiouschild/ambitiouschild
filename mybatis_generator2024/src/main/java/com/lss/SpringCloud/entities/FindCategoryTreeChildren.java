package com.lss.SpringCloud.entities;

import javax.persistence.*;

/**
 * 表名：findcategorytreechildren
*/
@Table(name = "findcategorytreechildren")
public class FindCategoryTreeChildren {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "imageUrl")
    private String imageurl;

    private String name;

    private Integer categorylistid;

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
     * @return imageurl
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     * @param imageurl
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

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
}