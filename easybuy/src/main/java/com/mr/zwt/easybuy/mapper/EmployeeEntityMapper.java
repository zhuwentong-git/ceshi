package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.EmployeeEntity;

public interface EmployeeEntityMapper {
    int deleteByPrimaryKey(String empId);

    int insert(EmployeeEntity record);

    int insertSelective(EmployeeEntity record);

    EmployeeEntity selectByPrimaryKey(String empId);

    int updateByPrimaryKeySelective(EmployeeEntity record);

    int updateByPrimaryKey(EmployeeEntity record);
}