package com.lss.SpringCloud.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 表名：parentcategory
*/

@Entity
@Table(name = "parentcategory")
public class ParentCategory {
    @Id
//    @GeneratedValue(generator = "JDBC")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //是Java Persistence API (JPA)中的一个注解，用于指定实体类属性的主键生成策略。
    // 这个注解通常用在实体类的主键字段上，以确保每个实体都有一个唯一的标识符。

    //java Persistence API 是Java EE平台的一部分，用于对象关系映射（ORM），它允许开发者将Java对象映射到关系数据库中的表。
    //GenerationType.IDENTITY 是JPA提供的几种主键生成策略之一。它依赖于数据库来生成主键值，通常是通过自增字段实现的。
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // mappedBy 指向子实体中的关联字段名
    @JsonManagedReference // 防止JSON无限递归
    private List<ChildrenCategory> childrenCategory = new ArrayList<>();

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