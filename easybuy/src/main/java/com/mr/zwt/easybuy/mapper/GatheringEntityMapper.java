package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.GatheringEntity;

public interface GatheringEntityMapper {
    int deleteByPrimaryKey(String gaId);

    int insert(GatheringEntity record);

    int insertSelective(GatheringEntity record);

    GatheringEntity selectByPrimaryKey(String gaId);

    int updateByPrimaryKeySelective(GatheringEntity record);

    int updateByPrimaryKey(GatheringEntity record);
}