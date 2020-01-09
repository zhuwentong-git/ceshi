package com.mr.zwt.easybuy.service.impl;

import org.springframework.util.StringUtils;
import com.mr.zwt.common.constant;
import com.mr.zwt.common.redis.RedisRepository;
import com.mr.zwt.common.utils.PasswordUtil;
import com.mr.zwt.easybuy.entity.UserEntity;
import com.mr.zwt.easybuy.entity.UseraddressEntity;
import com.mr.zwt.easybuy.mapper.UserEntityMapper;
import com.mr.zwt.easybuy.mapper.UseraddressEntityMapper;
import com.mr.zwt.easybuy.response.EasybuyResponse;
import com.mr.zwt.easybuy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @ClassName UserServiceImpl
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2019/12/25
 * @Version V1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserEntityMapper mapper;

    @Resource
    private UseraddressEntityMapper addrMapper;

    @Resource
    private RedisRepository redis;


    @Override
    public EasybuyResponse sendCheckCode(String phone) {
        int code = (int) Math.ceil(Math.random() * 100000);//定义验证码
        //将设置的验证码 放入redis 不放就会无法用验证码
        redis.set(constant.SEND_CODE_PREFIX + phone,code+"");
        redis.expire(constant.SEND_CODE_PREFIX+phone,80);
        //调用第三方 短信发送
//        code = 5201314;
//        LuosimaoDuanxinUtil.SendCode(phone,code + "");
        logger.info("验证码已发送" + code);

        return new EasybuyResponse();
    }

    @Override
    public EasybuyResponse checkCode(String phone, String code) {
        String s = redis.get(constant.SEND_CODE_PREFIX + phone);
        if (!StringUtils.isEmpty(s)){
            if (s.equals(code)){
                return new EasybuyResponse();
            }
        }
        return new EasybuyResponse("验证码输入错误");
    }

    @Override
    public EasybuyResponse save(UserEntity entity) {

        try {
            if (entity != null){
                if (StringUtils.isEmpty(entity.getUserId())){
                    entity.setUserPass(PasswordUtil.encode(entity.getUserPass()));
                    entity.setUserCreatDate(new Date());
                    entity.setUserNick("wt" + (int)(Math.random() * 1000000));
                    entity.setUserId(UUID.randomUUID().toString());
                    mapper.insertSelective(entity);

                }else{
                    mapper.updateByPrimaryKeySelective(entity);
                }
            }
            return new EasybuyResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return new EasybuyResponse(e.getMessage());
        }

    }

    @Override
    public EasybuyResponse list(UserEntity entity) {
        EasybuyResponse response = new EasybuyResponse();
        List<UserEntity> list = mapper.list(entity);
        response.setUserList(list);
        return response;
    }

    @Override
    public void setImgCode(String code, String ipAddress) {
        redis.set(constant.IMG_CODE_PRIFIX +ipAddress,code);
    }

    @Override
    public EasybuyResponse checkImgCode(String imgCode, String ip) {
        String s = redis.get(constant.IMG_CODE_PRIFIX + ip);
        if (!StringUtils.isEmpty(s) && !StringUtils.isEmpty(imgCode)){
            if (s.equalsIgnoreCase(imgCode)){

                return new EasybuyResponse();
            }
        }
        return new EasybuyResponse("验证码输入错误");
    }

    @Override
    public EasybuyResponse login(UserEntity entity, HttpServletRequest request, String ip) {
        EasybuyResponse response = new EasybuyResponse();
        if (null != entity){
            if (!StringUtils.isEmpty(entity.getUserPhoneCode())){
                UserEntity userEntity = new UserEntity();
                userEntity.setUserPhoneCode(entity.getUserPhoneCode());
                List<UserEntity> list = mapper.list(userEntity);
                if (list.size() == 1){
                    if (PasswordUtil.comparePassword(entity.getUserPass(),list.get(0).getUserPass())){
                        //登陆成功
                        request.getSession().setAttribute("user",list.get(0));
                         redis.del(constant.IMG_CODE_PRIFIX + ip);
                        response.setUserList(list);
                        return response;
                    }
                }
            }
        }
        response.setStatus(1);
        response.setMsg("密码输入错误");
        return response;
    }

    @Override
    public EasybuyResponse addrSave(UseraddressEntity entity) {

        try {
            if (null != entity){
                if (StringUtils.isEmpty(entity.getAddId())){
                    entity.setAddDate(new Date());
                    entity.setAddId(UUID.randomUUID().toString());
                    addrMapper.insertSelective(entity);
                }else{
                    addrMapper.updateByPrimaryKeySelective(entity);
                }
            }
            return new EasybuyResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return new EasybuyResponse(e.getMessage());
        }
    }

    @Override
    public EasybuyResponse addrList(UseraddressEntity entity, HttpServletRequest request) {
        EasybuyResponse response = new EasybuyResponse();
        UserEntity user = (UserEntity) request.getSession().getAttribute("user");
        entity.setUserId(user.getUserId());
        List<UseraddressEntity> list = addrMapper.list(entity);
        response.setUserAddressList(list);


        return response;
    }

}
