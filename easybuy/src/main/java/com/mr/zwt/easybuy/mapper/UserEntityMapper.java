package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.UserEntity;

import java.util.List;

public interface UserEntityMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);

    List<UserEntity> list(UserEntity entity);
}