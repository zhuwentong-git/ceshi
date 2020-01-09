package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.RepstaEntity;

public interface RepstaEntityMapper {
    int deleteByPrimaryKey(Integer rsId);

    int insert(RepstaEntity record);

    int insertSelective(RepstaEntity record);

    RepstaEntity selectByPrimaryKey(Integer rsId);

    int updateByPrimaryKeySelective(RepstaEntity record);

    int updateByPrimaryKey(RepstaEntity record);
}