package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.RolemenuEntity;

public interface RolemenuEntityMapper {
    int deleteByPrimaryKey(String rmId);

    int insert(RolemenuEntity record);

    int insertSelective(RolemenuEntity record);

    RolemenuEntity selectByPrimaryKey(String rmId);

    int updateByPrimaryKeySelective(RolemenuEntity record);

    int updateByPrimaryKey(RolemenuEntity record);
}