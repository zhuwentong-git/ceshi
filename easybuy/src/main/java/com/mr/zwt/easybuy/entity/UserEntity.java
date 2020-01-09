package com.mr.zwt.easybuy.entity;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable {
    private String userId;

    private String userPass;

    private String userNick;

    private String userPhoneCode;

    private Integer userStatus;

    private Date userCreatDate;

    private Integer userInte;

    private Integer userUserInte;

    private Integer userGrade;

    private String userImg;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass == null ? null : userPass.trim();
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick == null ? null : userNick.trim();
    }

    public String getUserPhoneCode() {
        return userPhoneCode;
    }

    public void setUserPhoneCode(String userPhoneCode) {
        this.userPhoneCode = userPhoneCode == null ? null : userPhoneCode.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserCreatDate() {
        return userCreatDate;
    }

    public void setUserCreatDate(Date userCreatDate) {
        this.userCreatDate = userCreatDate;
    }

    public Integer getUserInte() {
        return userInte;
    }

    public void setUserInte(Integer userInte) {
        this.userInte = userInte;
    }

    public Integer getUserUserInte() {
        return userUserInte;
    }

    public void setUserUserInte(Integer userUserInte) {
        this.userUserInte = userUserInte;
    }

    public Integer getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(Integer userGrade) {
        this.userGrade = userGrade;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg == null ? null : userImg.trim();
    }
}