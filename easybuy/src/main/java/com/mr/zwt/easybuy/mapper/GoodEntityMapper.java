package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.GoodEntity;

import java.util.List;

public interface GoodEntityMapper {
    int deleteByPrimaryKey(String goodId);

    int insert(GoodEntity record);

    int insertSelective(GoodEntity record);

    GoodEntity selectByPrimaryKey(String goodId);

    int updateByPrimaryKeySelective(GoodEntity record);

    int updateByPrimaryKey(GoodEntity record);

    List<GoodEntity> list(GoodEntity entity);

    List<String> findPk(GoodEntity entity);
}