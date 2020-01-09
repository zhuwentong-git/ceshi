package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.GoodTypeEntity;

import java.util.List;

public interface GoodTypeEntityMapper {
    int deleteByPrimaryKey(String typeId);

    int insert(GoodTypeEntity record);

    int insertSelective(GoodTypeEntity record);

    GoodTypeEntity selectByPrimaryKey(String typeId);

    int updateByPrimaryKeySelective(GoodTypeEntity record);

    int updateByPrimaryKey(GoodTypeEntity record);

    List<GoodTypeEntity> list();
}