package com.mr.zwt.easybuy.service.impl;


import com.mr.zwt.common.constant;
import com.mr.zwt.common.redis.RedisRepository;
import com.mr.zwt.easybuy.entity.GoodEntity;
import com.mr.zwt.easybuy.entity.UserEntity;
import com.mr.zwt.easybuy.response.EasybuyResponse;
import com.mr.zwt.easybuy.service.GoodCarService;
import com.mr.zwt.easybuy.vo.GoodCarVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodCarServiceImpl
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2019/12/26
 * @Version V1.0
 **/
@Service
public class GoodCarServiceImpl implements GoodCarService {



    Logger logger = LoggerFactory.getLogger(GoodCarServiceImpl.class);

    @Resource
    private RedisRepository redis;


    @Override
    public EasybuyResponse save(Map<String, List<GoodCarVO>> goodCar, HttpServletRequest request) {
        //获取当前用户的信息
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");

        for (Map.Entry<String,List<GoodCarVO>> entry : goodCar.entrySet()) {
            System.out.println(entry.getKey());
            //购物车信息
            List<GoodCarVO> value = entry.getValue();
            //从redis换从中获取数据
            //如果缓存中有商品的信息那就在它原基础count上加值
            //如果商品中没有该商品信息就list.add
            //key 先获取一下数据
//            List<GoodCarVO> list = redis.getList(constant.USER_GOOD_CAR_FRIFX + user.getUserId(), GoodCarVO.class);
//            if (null != list){
//                    for (GoodCarVO good :value){
//                        list.add(good);
//                    }                                这两个是把前面的list数据放入下一个
//                     list.addAll(value);
            // }
            for (GoodCarVO good : value) {
                String count = redis.getHash(constant.USER_GOOD_CAR_FRIFX + user.getUserId(), good.getGoodId(), String.class);
                if (StringUtils.isEmpty(count)) {

                    redis.setHash(constant.USER_GOOD_CAR_FRIFX + user.getUserId(), good.getGoodId(), good.getCount() + "");
                } else {

                    GoodEntity obj = redis.getObj(constant.GOOD_OBJ_PREFIX + good.getGoodId(), GoodEntity.class);

                    if ((good.getCount() + Integer.parseInt(count)) > obj.getGoodCount()) {

                        redis.setHash(constant.USER_GOOD_CAR_FRIFX + user.getUserId(), good.getGoodId(), obj.getGoodCount() + "");
                    } else {

                        redis.setHash(constant.USER_GOOD_CAR_FRIFX + user.getUserId(), good.getGoodId(),
                                (good.getCount() + Integer.parseInt(count)) + "");
                    }
                }


//            redis.setList(constant.USER_GOOD_CAR_FRIFX + user.getUserId(),list);
            }
        }
        return new EasybuyResponse();
    }

    @Override
    public EasybuyResponse list(HttpServletRequest request) {
        EasybuyResponse response = new EasybuyResponse();
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
       // List<GoodCarVO> redisList = redis.getList(constant.USER_GOOD_CAR_FRIFX + user.getUserId(), GoodCarVO.class);
        List<GoodCarVO> list = new ArrayList<>();
        Map<String, String> hash = redis.getHash(constant.USER_GOOD_CAR_FRIFX + user.getUserId());
        GoodCarVO goodCarVO = null;
        for (Map.Entry<String,String> map:hash.entrySet()){
                goodCarVO = new GoodCarVO();
                goodCarVO.setGoodId(map.getKey());
                goodCarVO.setCount(Integer.parseInt(map.getValue()));
                list.add(goodCarVO);
        }
        response.setGoodCarList(list);
       // response.setGoodCarList(redisList);
        return response;
    }
}






















