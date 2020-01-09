package com.mr.zwt.common.controller;

import org.springframework.util.StringUtils;
import com.mr.zwt.common.constant;
import com.mr.zwt.common.redis.RedisRepository;
import com.mr.zwt.common.utils.JsonUtils;
import com.mr.zwt.easybuy.controller.OrderController;
import com.mr.zwt.easybuy.entity.GoodEntity;
import com.mr.zwt.easybuy.entity.UserEntity;
import com.mr.zwt.easybuy.service.OrderService;
import com.mr.zwt.easybuy.vo.GoodCarVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName RediRectController
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2019/12/19
 * @Version V1.0
 **/
@Controller
public class RediRectController {
    @Autowired
    private OrderService orderService;

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    private static final String GOOD_OBJ_PREFIX = "good_obj_";
    @Resource
    private RedisRepository redis;

    @GetMapping(value = "/")
    public String list(){
        return "index";
    }
    @GetMapping(value = "hot")
    public String hotList(){
        return "hot";
    }
    @GetMapping(value = "product_list")
    public String pList(String typeId, ModelMap map){

        map.put("typeId",typeId);

        return "product-list";
    }
    @GetMapping(value = "product_view")
    public String pView(String goodId, ModelMap map){

        GoodEntity obj = redis.getObj(GOOD_OBJ_PREFIX + goodId, GoodEntity.class);

        map.put("good",obj);

        return "product-view";
    }
    @GetMapping(value = "register")
    public String register(){
        return "register";
    }
    @GetMapping(value = "login")
    public String login(){
        return "login";
    }
    @GetMapping(value = "shopping")
    public String shopping(){
        return "shopping";
    }
    @GetMapping(value = "product_order")
    public String product_order(String goodList, HttpServletRequest request){
        if(!StringUtils.isEmpty(goodList)){
            UserEntity user = (UserEntity) request.getSession().getAttribute("user");
            List<GoodCarVO> goodsCarVOS = JsonUtils.toList(goodList, GoodCarVO.class);
            redis.setList(constant.PREPARE_ORDER_PREFIX + user.getUserId(),goodsCarVOS);
        }


        return "product-order";
    }
    @GetMapping(value="order-list")
    public String order(){
        return "order";
    }
    @GetMapping(value = "pay_return")
    public String payReturn(String out_trade_no){
        //支付成功会执行此方法
        logger.info("支付成功回调,订单编号:{}",out_trade_no);
        orderService.updateByOrdCode(out_trade_no);
        //通过订单编号改变订单状态

        logger.info("----------payReturn--------------");
        return "index";
    }

}
