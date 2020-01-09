package com.mr.zwt.easybuy.service;

import com.mr.zwt.easybuy.entity.UserEntity;
import com.mr.zwt.easybuy.entity.UseraddressEntity;
import com.mr.zwt.easybuy.response.EasybuyResponse;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    EasybuyResponse sendCheckCode(String phone);

    EasybuyResponse checkCode(String phone, String code);

    EasybuyResponse save(UserEntity entity);

    EasybuyResponse list(UserEntity entity);

    void setImgCode(String code, String ipAddress);

    EasybuyResponse checkImgCode(String imgCode, String ip);


    EasybuyResponse login(UserEntity entity, HttpServletRequest request, String ipAddress);

    EasybuyResponse addrSave(UseraddressEntity entity);

    EasybuyResponse addrList(UseraddressEntity entity, HttpServletRequest request);
}
