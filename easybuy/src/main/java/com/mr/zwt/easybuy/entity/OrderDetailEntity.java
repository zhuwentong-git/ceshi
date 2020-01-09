package com.mr.zwt.easybuy.entity;

import java.util.Date;

public class OrderDetailEntity {
    private String deId;

    private String ordId;

    private String userId;

    private String goodId;

    private String goodName;

    private Double goodPrice;

    private Integer buyCount;

    private Date buyDate;

    private Integer buyInte;

    public String getDeId() {
        return deId;
    }

    public void setDeId(String deId) {
        this.deId = deId == null ? null : deId.trim();
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId == null ? null : ordId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public Double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Integer getBuyInte() {
        return buyInte;
    }

    public void setBuyInte(Integer buyInte) {
        this.buyInte = buyInte;
    }

    @Override
    public String toString() {
        return "OrderDetailEntity{" +
                "deId='" + deId + '\'' +
                ", ordId='" + ordId + '\'' +
                ", userId='" + userId + '\'' +
                ", goodId='" + goodId + '\'' +
                ", goodName='" + goodName + '\'' +
                ", goodPrice=" + goodPrice +
                ", buyCount=" + buyCount +
                ", buyDate=" + buyDate +
                ", buyInte=" + buyInte +
                '}';
    }
}