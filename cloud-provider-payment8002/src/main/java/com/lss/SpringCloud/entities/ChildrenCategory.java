package com.lss.SpringCloud.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * 表名：childrencategory
*/

@Entity
@Table(name = "childrencategory")
public class ChildrenCategory {
    @Id
//    @GeneratedValue(generator = "JDBC")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //是Java Persistence API (JPA)中的一个注解，用于指定实体类属性的主键生成策略。
    // 这个注解通常用在实体类的主键字段上，以确保每个实体都有一个唯一的标识符。

    //java Persistence API 是Java EE平台的一部分，用于对象关系映射（ORM），它允许开发者将Java对象映射到关系数据库中的表。
    //GenerationType.IDENTITY 是JPA提供的几种主键生成策略之一。它依赖于数据库来生成主键值，通常是通过自增字段实现的。
    private Integer id;

    @Column(name = "imageUrl")
    private String imageurl;

    private String name;

    @Column(name = "parent_id")
    //这里用的是Integer类型，因为我们希望通过parentId来关联一级分类。也可以使用@ManyToOne注解来关联CategoryLevel1对象。
    private Integer parentId;


    @ManyToOne(fetch = FetchType.LAZY) // 如果使用对象引用关联，则不需要此字段。仅当使用Integer类型时需要此字段。
    @JoinColumn(name = "parent_id", insertable = false, updatable = false)// 确保与数据库外键列名一致
    @JsonBackReference // 防止JSON无限递归// 使用JoinColumn来指定外键字段名。如果用对象引用则不需要此注解。
    private ParentCategory parent; // 这里用的是多对一关系，因为我们知道每个二级分类都属于一个一级分类。
    // 字段名是 parent（对应 mappedBy）

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
     * @return parentId
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}