package com.mr.zwt.easybuy.entity;

import java.util.Date;

public class RepstaEntity {
    private Integer rsId;

    private Integer goodType;

    private String goodId;

    private String goodName;

    private Double goodPirce;

    private Integer goodCount;

    private Date goodSaleDate;

    private String goodOrderDateilId;

    public Integer getRsId() {
        return rsId;
    }

    public void setRsId(Integer rsId) {
        this.rsId = rsId;
    }

    public Integer getGoodType() {
        return goodType;
    }

    public void setGoodType(Integer goodType) {
        this.goodType = goodType;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public Double getGoodPirce() {
        return goodPirce;
    }

    public void setGoodPirce(Double goodPirce) {
        this.goodPirce = goodPirce;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public Date getGoodSaleDate() {
        return goodSaleDate;
    }

    public void setGoodSaleDate(Date goodSaleDate) {
        this.goodSaleDate = goodSaleDate;
    }

    public String getGoodOrderDateilId() {
        return goodOrderDateilId;
    }

    public void setGoodOrderDateilId(String goodOrderDateilId) {
        this.goodOrderDateilId = goodOrderDateilId == null ? null : goodOrderDateilId.trim();
    }
}