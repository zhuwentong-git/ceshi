package com.mr.zwt.easybuy.controller;

import com.mr.zwt.common.utils.ImgCodeUtils;
import com.mr.zwt.easybuy.entity.UserEntity;
import com.mr.zwt.easybuy.entity.UseraddressEntity;
import com.mr.zwt.easybuy.response.EasybuyResponse;
import com.mr.zwt.easybuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2019/12/25
 * @Version V1.0
 **/
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService service;


    @PostMapping(value="addr")
    public EasybuyResponse addrSave(@RequestBody UseraddressEntity entity){

        return service.addrSave(entity);

    }

    @GetMapping(value="addr")
    public EasybuyResponse addrList(UseraddressEntity entity,HttpServletRequest request){
        return service.addrList(entity,request);
    }


    @GetMapping(value = "sendChckCode")
    public EasybuyResponse sendCheckCode(String phone){
        return service.sendCheckCode(phone);
    }
    @GetMapping(value = "checkCode")
    public EasybuyResponse checkCode(String phone,String code){
        return service.checkCode(phone,code);
    }
    @PostMapping
    public EasybuyResponse save(@RequestBody UserEntity entity){

        return service.save(entity);
    }
    @PostMapping(value="login")
    public EasybuyResponse login(@RequestBody UserEntity entity,HttpServletRequest request){
        return service.login(entity,request,this.getIpAddress(request));
    }

    @GetMapping
    public EasybuyResponse list(UserEntity entity){
        return service.list(entity);
    }
    @GetMapping(value = "checkImgCode")
    public EasybuyResponse checkImgCode(String imgCode,HttpServletRequest request){
        return service.checkImgCode(imgCode,this.getIpAddress(request));
    }
    @GetMapping(value = "imgCode")
    public void getImgCode(HttpServletResponse response, HttpServletRequest request){

        Map<String, Object> generate = ImgCodeUtils.generate(80, 28);

        String code = (String) generate.get("code");
        String ipAddress = this.getIpAddress(request);
        service.setImgCode(code,ipAddress);
        //不使用http缓存
        response.setHeader("Pragma", "no-cache");
        //设置响应头
        response.setHeader("Cache-Control", "no-cache");
        //在代理服务器端防止缓冲
        response.setDateHeader("Expires", 0);
        //设置响应内容类型
        response.setContentType("image/jpeg");
        try {
            response.getOutputStream().write((byte[])generate.get("imgBytes"));
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private String getIpAddress(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");

        if(ip == null || ip.length() == 0 || "unknow".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader ("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals ("127.0.0.1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf (",") > 0) {
                ip = ip.substring (0, ip.indexOf (","));
            }
        }
        return ip;
    }

}
