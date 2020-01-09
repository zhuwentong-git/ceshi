package com.mr.zwt.easybuy.entity;

import java.util.Date;

public class UseraddressEntity {
    private String addId;

    private String userId;

    private String addPro;

    private String addCity;

    private String addCounty;

    private String addCountry;

    private String addDetail;

    private String addUser;

    private String addPhone;

    private Date addDate;

    public String getAddId() {
        return addId;
    }

    public void setAddId(String addId) {
        this.addId = addId == null ? null : addId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAddPro() {
        return addPro;
    }

    public void setAddPro(String addPro) {
        this.addPro = addPro == null ? null : addPro.trim();
    }

    public String getAddCity() {
        return addCity;
    }

    public void setAddCity(String addCity) {
        this.addCity = addCity == null ? null : addCity.trim();
    }

    public String getAddCounty() {
        return addCounty;
    }

    public void setAddCounty(String addCounty) {
        this.addCounty = addCounty == null ? null : addCounty.trim();
    }

    public String getAddCountry() {
        return addCountry;
    }

    public void setAddCountry(String addCountry) {
        this.addCountry = addCountry == null ? null : addCountry.trim();
    }

    public String getAddDetail() {
        return addDetail;
    }

    public void setAddDetail(String addDetail) {
        this.addDetail = addDetail == null ? null : addDetail.trim();
    }

    public String getAddUser() {
        return addUser;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser == null ? null : addUser.trim();
    }

    public String getAddPhone() {
        return addPhone;
    }

    public void setAddPhone(String addPhone) {
        this.addPhone = addPhone == null ? null : addPhone.trim();
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}