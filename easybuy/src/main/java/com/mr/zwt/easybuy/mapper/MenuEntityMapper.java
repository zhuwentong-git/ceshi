package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.MenuEntity;

public interface MenuEntityMapper {
    int deleteByPrimaryKey(String meId);

    int insert(MenuEntity record);

    int insertSelective(MenuEntity record);

    MenuEntity selectByPrimaryKey(String meId);

    int updateByPrimaryKeySelective(MenuEntity record);

    int updateByPrimaryKey(MenuEntity record);
}