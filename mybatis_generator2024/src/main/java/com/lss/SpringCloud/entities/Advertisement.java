package com.lss.SpringCloud.entities;

import javax.persistence.*;

/**
 * 表名：advertisement
*/
@Table(name = "advertisement")
public class Advertisement {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "imageUrl")
    private String imageurl;

    @Column(name = "category2Id")
    private Integer category2id;

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
     * @return category2id
     */
    public Integer getCategory2id() {
        return category2id;
    }

    /**
     * @param category2id
     */
    public void setCategory2id(Integer category2id) {
        this.category2id = category2id;
    }
}