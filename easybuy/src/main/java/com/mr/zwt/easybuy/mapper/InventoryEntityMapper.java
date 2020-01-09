package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.InventoryEntity;

public interface InventoryEntityMapper {
    int deleteByPrimaryKey(String ioId);

    int insert(InventoryEntity record);

    int insertSelective(InventoryEntity record);

    InventoryEntity selectByPrimaryKey(String ioId);

    int updateByPrimaryKeySelective(InventoryEntity record);

    int updateByPrimaryKey(InventoryEntity record);
}