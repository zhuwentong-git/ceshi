package com.mr.zwt.easybuy.service.impl;

import com.mr.zwt.common.constant;
import com.mr.zwt.common.redis.RedisRepository;
import com.mr.zwt.easybuy.entity.GoodTypeEntity;
import com.mr.zwt.easybuy.mapper.GoodTypeEntityMapper;
import com.mr.zwt.easybuy.response.EasybuyResponse;
import com.mr.zwt.easybuy.service.GoodsTypeService;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName GoodsTypeServiceImpl
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2019/12/20
 * @Version V1.0
 **/
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {


    @Resource
    private GoodTypeEntityMapper mapper;

    @Resource
    private RedisRepository redis;

    @Override
    public EasybuyResponse list() {
        EasybuyResponse response = new EasybuyResponse();
       List<GoodTypeEntity> list = redis.getList(constant.GOODS_TYPE_LIST,GoodTypeEntity.class);
       if (null == list || list.size() <= 0){
           System.out.println("从数据库查询");
           list = mapper.list();//这个好像是从数据库查询 如果缓存中有了 就不会走
        redis.expire(constant.GOODS_TYPE_LIST,60*60);//设置时间
        redis.setList(constant.GOODS_TYPE_LIST,list);//往缓存中set数据
       }else{
           System.out.println("从缓存");
       }
       response.setGoodTypeList(list);
        return response;
    }

    @Override
    public EasybuyResponse save(GoodTypeEntity entity) {
        try {
            if (entity != null){
                if (!StringUtils.isEmpty(entity.getTypeId())){
                    mapper.updateByPrimaryKeySelective(entity);
                }else{
                    entity.setTypeId(UUID.randomUUID().toString());

                    mapper.insertSelective(entity);
                }

            }
            return new EasybuyResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return new EasybuyResponse(e.getMessage());
        }

}
}
