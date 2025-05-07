package com.lss.SpringCloud.entities;

import javax.persistence.*;

/**
 * 表名：category_level1
*/
@Table(name = "category_level1")
public class Category_level1 {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;

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
}