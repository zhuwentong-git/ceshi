package com.mr.zwt.easybuy.service.impl;

import com.mr.zwt.common.constant;
import com.mr.zwt.common.redis.RedisRepository;
import com.mr.zwt.easybuy.entity.GoodEntity;
import com.mr.zwt.easybuy.entity.OrderDetailEntity;
import com.mr.zwt.easybuy.entity.OrderEntity;
import com.mr.zwt.easybuy.entity.UserEntity;
import com.mr.zwt.easybuy.mapper.OrderDetailEntityMapper;
import com.mr.zwt.easybuy.mapper.OrderEntityMapper;
import com.mr.zwt.easybuy.response.EasybuyResponse;
import com.mr.zwt.easybuy.service.OrderService;
import com.mr.zwt.easybuy.vo.GoodCarVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @ClassName OrderServiceImpl
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2019/12/31
 * @Version V1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {
    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Resource
    private RedisRepository redis;
    @Resource
    private OrderDetailEntityMapper orderDetailMapper;
    @Resource
    private OrderEntityMapper orderMapper;

    @Override
    public EasybuyResponse save(OrderEntity entity, HttpServletRequest request) {
        //获取用户信息
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        Date date = new Date();
        entity.setOrdId(UUID.randomUUID().toString());
        entity.setUserId(user.getUserId());
        entity.setOrdCode("zhu" + date.getTime());

        entity.setOrdCreateDate(date);

        //当前时间加一天
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DAY_OF_MONTH,1);
        entity.setOrdPastDate(instance.getTime());
        entity.setOrdStatus(1);
        //订单总金额-->获取当前用户下订单的商品(单价*数量)
        Double total = 0D;
        String orderName = "";
        //从缓存中获取购物车商品
        List<GoodCarVO> list = redis.getList(constant.PREPARE_ORDER_PREFIX + user.getUserId(), GoodCarVO.class);
        GoodEntity obj = null;
        OrderDetailEntity detailEntity = null;
        List<OrderDetailEntity> orderDetailEntities = new ArrayList<>();
        for (GoodCarVO gcVO : list){
            //获取商品信息
          obj = redis.getObj(constant.GOOD_OBJ_PREFIX + gcVO.getGoodId(),GoodEntity.class);

          //清除购物车的商品信息
            redis.delHash(constant.USER_GOOD_CAR_FRIFX + user.getUserId() ,gcVO.getGoodId());

          total += obj.getGoodPrice() * gcVO.getCount();
          orderName += obj.getGoodName() + '-';
           detailEntity = new OrderDetailEntity();
            detailEntity.setDeId(UUID.randomUUID().toString());
            detailEntity.setOrdId(entity.getOrdId());
            detailEntity.setUserId(user.getUserId());
            detailEntity.setGoodId(gcVO.getGoodId());
            detailEntity.setGoodName(obj.getGoodName());
            detailEntity.setGoodPrice(obj.getGoodPrice());
            detailEntity.setBuyCount(gcVO.getCount());
            detailEntity.setBuyDate(date);

            orderDetailEntities.add(detailEntity);
        }
        entity.setOrdName(orderName.substring(0,orderName.lastIndexOf("-")));
        entity.setOrdMoney(total);
        logger.info("---订单信息--->" + entity.toString());
        orderMapper.insertSelective(entity);
        orderDetailMapper.batchAdd(orderDetailEntities);
        logger.info("----订单详情-->" + orderDetailEntities);
        //清空redis里的预存信息
        redis.del(constant.PREPARE_ORDER_PREFIX + user.getUserId());

        return new EasybuyResponse();
    }

    @Override
    public EasybuyResponse list(OrderEntity entity,HttpServletRequest request) {
        EasybuyResponse response = new EasybuyResponse();
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        entity.setUserId(user.getUserId());
        List<OrderEntity>  list = orderMapper.list(entity);
        list.forEach(order ->{
            if (order != null){
                if (order.getOrdStatus() == 1){
                    Date ordPastDate = order.getOrdPastDate();
                    Date date = new Date();
                    if (date.getTime() > ordPastDate.getTime()){
                        order.setOrdStatus(3);
                        orderMapper.updateByPrimaryKeySelective(order);
                    }
                }
            }


        });

        response.setOrderList(list);
        return response;
    }

    @Override
    public EasybuyResponse listDetail(OrderDetailEntity entity) {
        EasybuyResponse response = new EasybuyResponse();
        List<OrderDetailEntity> listDetail =  orderDetailMapper.listDetail(entity);
        response.setOrderDetailList(listDetail);
        return response;
    }

    @Override
    public void updateByOrdCode(String out_trade_no) {
        orderMapper.updateByOrdCode(out_trade_no);
    }
}













