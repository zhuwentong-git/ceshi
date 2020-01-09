package com.mr.zwt.easybuy.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.mr.zwt.common.constant;
import com.mr.zwt.easybuy.entity.OrderDetailEntity;
import com.mr.zwt.easybuy.entity.OrderEntity;
import com.mr.zwt.easybuy.response.EasybuyResponse;
import com.mr.zwt.easybuy.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName OrderController
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2019/12/31
 * @Version V1.0
 **/
@RestController
@RequestMapping(value = "order")
public class OrderController {
    @Autowired
    private OrderService service;

    Logger logger = LoggerFactory.getLogger(OrderController.class);
    @PostMapping
    public EasybuyResponse save(@RequestBody OrderEntity entity, HttpServletRequest request){
        return service.save(entity,request);
    }

    @GetMapping
    public EasybuyResponse list(OrderEntity entity,HttpServletRequest request){
      return  service.list(entity,request);
    }

    @GetMapping(value = "listDetail")
    public EasybuyResponse listDetail(OrderDetailEntity entity){
        return service.listDetail(entity);
    }

    @GetMapping(value = "pay")
    public void pay(OrderEntity entity, HttpServletResponse response,HttpServletRequest request) {

        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(constant.GATEWAYURL, constant.APP_ID,
                constant.MERCHANT_PRIVATE_KEY, "json", constant.CHARSET,
                constant.ALIPAY_PUBLIC_KEY, constant.SIGN_TYPE);
        // 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(constant.RETURN_URL);
        alipayRequest.setNotifyUrl(constant.NOTIFY_URL);

        // 商户订单号，商户网站订单系统中唯一订单号，必填
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrdId(entity.getOrdId());
        EasybuyResponse orderResponse = service.list(orderEntity,request);

        if(orderResponse.getStatus() == 0){
            String out_trade_no = orderResponse.getOrderList().get(0).getOrdCode();
            // 付款金额，必填
            String total_amount = entity.getOrdMoney() + "";


            String subject = "mingrui";
            String body = "zhuwentong";
            alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
                    + "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
            // 请求
            try {
                String result = alipayClient.pageExecute(alipayRequest).getBody();
                System.out.println(result);
                response.setContentType("text/html; charset=gbk");
                PrintWriter out = response.getWriter();
                out.print(result);
            } catch (AlipayApiException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @PostMapping(value = "pay_notify")
    public void payNotify(){

        logger.info("--------------payNotify----------------");
    }


}
