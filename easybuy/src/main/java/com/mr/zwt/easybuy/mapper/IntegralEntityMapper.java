package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.IntegralEntity;

public interface IntegralEntityMapper {
    int deleteByPrimaryKey(Integer intId);

    int insert(IntegralEntity record);

    int insertSelective(IntegralEntity record);

    IntegralEntity selectByPrimaryKey(Integer intId);

    int updateByPrimaryKeySelective(IntegralEntity record);

    int updateByPrimaryKey(IntegralEntity record);
}