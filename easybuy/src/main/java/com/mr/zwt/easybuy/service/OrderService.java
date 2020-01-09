package com.mr.zwt.easybuy.service;

import com.mr.zwt.easybuy.entity.OrderDetailEntity;
import com.mr.zwt.easybuy.entity.OrderEntity;
import com.mr.zwt.easybuy.response.EasybuyResponse;

import javax.servlet.http.HttpServletRequest;

public interface OrderService {
    EasybuyResponse save(OrderEntity entity, HttpServletRequest request);

    EasybuyResponse list(OrderEntity entity,HttpServletRequest request);

    EasybuyResponse listDetail(OrderDetailEntity entity);

    void updateByOrdCode(String out_trade_no);
}
