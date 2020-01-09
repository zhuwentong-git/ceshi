package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.EmpRpleEntity;

public interface EmpRpleEntityMapper {
    int deleteByPrimaryKey(String erId);

    int insert(EmpRpleEntity record);

    int insertSelective(EmpRpleEntity record);

    EmpRpleEntity selectByPrimaryKey(String erId);

    int updateByPrimaryKeySelective(EmpRpleEntity record);

    int updateByPrimaryKey(EmpRpleEntity record);
}