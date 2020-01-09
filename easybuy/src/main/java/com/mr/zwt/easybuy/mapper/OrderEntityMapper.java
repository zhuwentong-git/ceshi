package com.mr.zwt.easybuy.mapper;

import com.mr.zwt.easybuy.entity.OrderEntity;

import java.util.List;

public interface OrderEntityMapper {
    int deleteByPrimaryKey(String ordId);

    int insert(OrderEntity record);

    int insertSelective(OrderEntity record);

    OrderEntity selectByPrimaryKey(String ordId);

    int updateByPrimaryKeySelective(OrderEntity record);

    int updateByPrimaryKey(OrderEntity record);

    List<OrderEntity> list(OrderEntity entity);

    void updateByOrdCode(String out_trade_no);
}