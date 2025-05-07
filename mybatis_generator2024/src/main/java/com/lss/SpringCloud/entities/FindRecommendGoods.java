package com.lss.SpringCloud.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 表名：findrecommendgoods
*/
@Table(name = "findrecommendgoods")
public class FindRecommendGoods {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "createTime")
    private Date createtime;

    @Column(name = "updateTime")
    private Date updatetime;

    @Column(name = "isDeleted")
    private String isdeleted;

    @Column(name = "category1Id")
    private Integer category1id;

    @Column(name = "category2Id")
    private Integer category2id;

    private String name;

    private BigDecimal price;

    @Column(name = "marketPrice")
    private BigDecimal marketprice;

    @Column(name = "saleCount")
    private String salecount;

    @Column(name = "stockCount")
    private String stockcount;

    @Column(name = "imageUrl")
    private String imageurl;

    @Column(name = "floralLanguage")
    private String florallanguage;

    @Column(name = "applyUser")
    private String applyuser;

    private String material;

    private String packing;

    @Column(name = "isRecommend")
    private String isrecommend;

    @Column(name = "detailList")
    private String detaillist;

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
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return updatetime
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * @return isdeleted
     */
    public String getIsdeleted() {
        return isdeleted;
    }

    /**
     * @param isdeleted
     */
    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    /**
     * @return category1id
     */
    public Integer getCategory1id() {
        return category1id;
    }

    /**
     * @param category1id
     */
    public void setCategory1id(Integer category1id) {
        this.category1id = category1id;
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
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return marketprice
     */
    public BigDecimal getMarketprice() {
        return marketprice;
    }

    /**
     * @param marketprice
     */
    public void setMarketprice(BigDecimal marketprice) {
        this.marketprice = marketprice;
    }

    /**
     * @return salecount
     */
    public String getSalecount() {
        return salecount;
    }

    /**
     * @param salecount
     */
    public void setSalecount(String salecount) {
        this.salecount = salecount;
    }

    /**
     * @return stockcount
     */
    public String getStockcount() {
        return stockcount;
    }

    /**
     * @param stockcount
     */
    public void setStockcount(String stockcount) {
        this.stockcount = stockcount;
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
     * @return florallanguage
     */
    public String getFlorallanguage() {
        return florallanguage;
    }

    /**
     * @param florallanguage
     */
    public void setFlorallanguage(String florallanguage) {
        this.florallanguage = florallanguage;
    }

    /**
     * @return applyuser
     */
    public String getApplyuser() {
        return applyuser;
    }

    /**
     * @param applyuser
     */
    public void setApplyuser(String applyuser) {
        this.applyuser = applyuser;
    }

    /**
     * @return material
     */
    public String getMaterial() {
        return material;
    }

    /**
     * @param material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * @return packing
     */
    public String getPacking() {
        return packing;
    }

    /**
     * @param packing
     */
    public void setPacking(String packing) {
        this.packing = packing;
    }

    /**
     * @return isrecommend
     */
    public String getIsrecommend() {
        return isrecommend;
    }

    /**
     * @param isrecommend
     */
    public void setIsrecommend(String isrecommend) {
        this.isrecommend = isrecommend;
    }

    /**
     * @return detaillist
     */
    public String getDetaillist() {
        return detaillist;
    }

    /**
     * @param detaillist
     */
    public void setDetaillist(String detaillist) {
        this.detaillist = detaillist;
    }
}