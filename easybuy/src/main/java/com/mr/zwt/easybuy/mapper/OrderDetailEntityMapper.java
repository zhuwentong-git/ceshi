package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.OrderDetailEntity;

import java.util.List;

public interface OrderDetailEntityMapper {
    int deleteByPrimaryKey(String deId);

    int insert(OrderDetailEntity record);

    int insertSelective(OrderDetailEntity record);

    OrderDetailEntity selectByPrimaryKey(String deId);

    int updateByPrimaryKeySelective(OrderDetailEntity record);

    int updateByPrimaryKey(OrderDetailEntity record);

    void batchAdd(List<OrderDetailEntity> orderDetailEntities);

    List<OrderDetailEntity> listDetail(OrderDetailEntity entity);
}