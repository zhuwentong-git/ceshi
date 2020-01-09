package com.mr.zwt.easybuy.entity;

import java.util.Date;

public class GatheringEntity {
    private String gaId;

    private String ordId;

    private Double gaPrice;

    private Date gaDate;

    private Integer gaStatus;

    public String getGaId() {
        return gaId;
    }

    public void setGaId(String gaId) {
        this.gaId = gaId == null ? null : gaId.trim();
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId == null ? null : ordId.trim();
    }

    public Double getGaPrice() {
        return gaPrice;
    }

    public void setGaPrice(Double gaPrice) {
        this.gaPrice = gaPrice;
    }

    public Date getGaDate() {
        return gaDate;
    }

    public void setGaDate(Date gaDate) {
        this.gaDate = gaDate;
    }

    public Integer getGaStatus() {
        return gaStatus;
    }

    public void setGaStatus(Integer gaStatus) {
        this.gaStatus = gaStatus;
    }
}