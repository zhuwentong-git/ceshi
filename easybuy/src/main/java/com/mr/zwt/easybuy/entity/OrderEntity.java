package com.mr.zwt.easybuy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderEntity {
    private String ordId;

    private String userId;

    private String ordCode;

    private String ordName;

    private Date ordCreateDate;

    private Date ordPastDate;

    private Double ordMoney;

    private Integer ordStatus;

    private String ordAdd;

    private Integer ordExpressCom;

    private String ordExpCode;

    private Integer ordPayType;

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

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode == null ? null : ordCode.trim();
    }

    public String getOrdName() {
        return ordName;
    }

    public void setOrdName(String ordName) {
        this.ordName = ordName == null ? null : ordName.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getOrdCreateDate() {
        return ordCreateDate;
    }

    public void setOrdCreateDate(Date ordCreateDate) {
        this.ordCreateDate = ordCreateDate;
    }
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getOrdPastDate() {
        return ordPastDate;
    }

    public void setOrdPastDate(Date ordPastDate) {
        this.ordPastDate = ordPastDate;
    }

    public Double getOrdMoney() {
        return ordMoney;
    }

    public void setOrdMoney(Double ordMoney) {
        this.ordMoney = ordMoney;
    }

    public Integer getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(Integer ordStatus) {
        this.ordStatus = ordStatus;
    }

    public String getOrdAdd() {
        return ordAdd;
    }

    public void setOrdAdd(String ordAdd) {
        this.ordAdd = ordAdd == null ? null : ordAdd.trim();
    }

    public Integer getOrdExpressCom() {
        return ordExpressCom;
    }

    public void setOrdExpressCom(Integer ordExpressCom) {
        this.ordExpressCom = ordExpressCom;
    }

    public String getOrdExpCode() {
        return ordExpCode;
    }

    public void setOrdExpCode(String ordExpCode) {
        this.ordExpCode = ordExpCode == null ? null : ordExpCode.trim();
    }

    public Integer getOrdPayType() {
        return ordPayType;
    }

    public void setOrdPayType(Integer ordPayType) {
        this.ordPayType = ordPayType;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "ordId='" + ordId + '\'' +
                ", userId='" + userId + '\'' +
                ", ordCode='" + ordCode + '\'' +
                ", ordName='" + ordName + '\'' +
                ", ordCreateDate=" + ordCreateDate +
                ", ordPastDate=" + ordPastDate +
                ", ordMoney=" + ordMoney +
                ", ordStatus=" + ordStatus +
                ", ordAdd='" + ordAdd + '\'' +
                ", ordExpressCom=" + ordExpressCom +
                ", ordExpCode='" + ordExpCode + '\'' +
                ", ordPayType=" + ordPayType +
                '}';
    }
}