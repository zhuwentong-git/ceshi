package com.mr.zwt.easybuy.controller;

import com.mr.zwt.easybuy.response.EasybuyResponse;
import com.mr.zwt.easybuy.service.GoodCarService;
import com.mr.zwt.easybuy.vo.GoodCarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GoodCarController
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2019/12/26
 * @Version V1.0
 **/
@RestController
@RequestMapping(value = "goodCar")
public class GoodCarController {
    @Autowired
    private GoodCarService service;
    @PostMapping
    public EasybuyResponse save(@RequestBody Map<String,List<GoodCarVO>> goodCar, HttpServletRequest request){
        return service.save(goodCar,request);
    }
    @GetMapping
    public EasybuyResponse list(HttpServletRequest request){
        return service.list(request);
    }
}
