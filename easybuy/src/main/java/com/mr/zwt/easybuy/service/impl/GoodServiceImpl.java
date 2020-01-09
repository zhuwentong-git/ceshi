package com.mr.zwt.easybuy.service.impl;


import com.mr.zwt.common.constant;
import com.mr.zwt.common.redis.RedisRepository;
import com.mr.zwt.easybuy.entity.GoodEntity;
import com.mr.zwt.easybuy.mapper.GoodEntityMapper;
import com.mr.zwt.easybuy.response.EasybuyResponse;
import com.mr.zwt.easybuy.service.GoodService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName GoodServiceImpl
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2019/12/20
 * @Version V1.0
 **/
@Service
public class GoodServiceImpl implements GoodService {




    @Resource
    private GoodEntityMapper mapper;

    @Resource
    private RedisRepository redis;

    @Override
    public EasybuyResponse list(GoodEntity entity) {
        EasybuyResponse response = new EasybuyResponse();
        List<GoodEntity> list = new ArrayList<>();
        //通过主键查询数据
        List<String> findPk = mapper.findPk(entity);
        for (String id :findPk){
            //通过主键查询内存中是否有数据
            GoodEntity obj = redis.getObj(constant.GOOD_OBJ_PREFIX + id, GoodEntity.class);
            //如果没有查询到数据
            if (obj == null){
                System.out.println("从数据库查询");
                 obj = mapper.selectByPrimaryKey(id);
                redis.setObj(constant.GOOD_OBJ_PREFIX + id,obj);
                redis.expire(constant.GOOD_OBJ_PREFIX +id,60*60);
            }else{
                System.out.println("从缓存查询");
            }
            list.add(obj);
        }

        //List<GoodEntity> list = mapper.list(entity);
        response.setGoodList(list);
        return response;
    }

    @Override
    public EasybuyResponse save(GoodEntity entity) {
        try {
            if (!StringUtils.isEmpty(entity.getGoodId())){
                mapper.updateByPrimaryKeySelective(entity);
            }else{
                entity.setGoodCreateDate(new Date());
                entity.setGoodId(UUID.randomUUID().toString());
                mapper.insertSelective(entity);
            }
            return new EasybuyResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return new EasybuyResponse(e.getMessage());
        }

    }
}
