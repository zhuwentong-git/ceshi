package com.mr.zwt.easybuy.entity;

import java.util.Date;

public class IntegralEntity {
    private Integer intId;

    private String userId;

    private String ordId;

    private Integer intCount;

    private Date intDate;

    private Integer intStatus;

    public Integer getIntId() {
        return intId;
    }

    public void setIntId(Integer intId) {
        this.intId = intId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId == null ? null : ordId.trim();
    }

    public Integer getIntCount() {
        return intCount;
    }

    public void setIntCount(Integer intCount) {
        this.intCount = intCount;
    }

    public Date getIntDate() {
        return intDate;
    }

    public void setIntDate(Date intDate) {
        this.intDate = intDate;
    }

    public Integer getIntStatus() {
        return intStatus;
    }

    public void setIntStatus(Integer intStatus) {
        this.intStatus = intStatus;
    }
}