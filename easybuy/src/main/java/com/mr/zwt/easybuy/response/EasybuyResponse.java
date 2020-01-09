package com.mr.zwt.easybuy.response;

import com.mr.zwt.easybuy.entity.*;
import com.mr.zwt.easybuy.vo.GoodCarVO;

import java.util.List;

/**
 * @ClassName EasybuyResponse
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2019/12/20
 * @Version V1.0
 **/
public class EasybuyResponse {
    private Integer status = 0;//0是成功 1是失败
    private  String msg;//这个是失败回调函数
    private List<GoodTypeEntity> goodTypeList;//goodType集合 把数据放到里面
    private List<GoodEntity> goodList;
    private List<UserEntity> userList;
    private List<GoodCarVO> GoodCarList;
    private List<UseraddressEntity> UserAddressList;
    private List<OrderEntity> OrderList;
    private List<OrderDetailEntity> OrderDetailList;

    public List<OrderEntity> getOrderList() {
        return OrderList;
    }

    public void setOrderList(List<OrderEntity> orderList) {
        OrderList = orderList;
    }

    public List<OrderDetailEntity> getOrderDetailList() {
        return OrderDetailList;
    }

    public void setOrderDetailList(List<OrderDetailEntity> orderDetailList) {
        OrderDetailList = orderDetailList;
    }

    public List<UseraddressEntity> getUserAddressList() {
        return UserAddressList;
    }

    public void setUserAddressList(List<UseraddressEntity> userAddressList) {
        UserAddressList = userAddressList;
    }

    public List<GoodCarVO> getGoodCarList() {
        return GoodCarList;
    }

    public void setGoodCarList(List<GoodCarVO> goodCarList) {
        GoodCarList = goodCarList;
    }

    public List<UserEntity> getUserList() {
        return userList;
    }

    public void setUserList(List<UserEntity> userList) {
        this.userList = userList;
    }

    public List<GoodEntity> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<GoodEntity> goodList) {
        this.goodList = goodList;
    }

    public EasybuyResponse(String msg) {
        this.status = 1;
        this.msg = msg;
    }
    public EasybuyResponse() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<GoodTypeEntity> getGoodTypeList() {
        return goodTypeList;
    }

    public void setGoodTypeList(List<GoodTypeEntity> goodTypeList) {
        this.goodTypeList = goodTypeList;
    }
}
