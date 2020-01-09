package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.RoleEntity;

public interface RoleEntityMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    RoleEntity selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);
}