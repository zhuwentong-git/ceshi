package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.UseraddressEntity;

import java.util.List;

public interface UseraddressEntityMapper {
    int deleteByPrimaryKey(String addId);

    int insert(UseraddressEntity record);

    int insertSelective(UseraddressEntity record);

    UseraddressEntity selectByPrimaryKey(String addId);

    int updateByPrimaryKeySelective(UseraddressEntity record);

    int updateByPrimaryKey(UseraddressEntity record);

    List<UseraddressEntity> list(UseraddressEntity entity);
}