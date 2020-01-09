package com.mr.zwt.easybuy.controller;

import com.mr.zwt.easybuy.entity.GoodEntity;
import com.mr.zwt.easybuy.response.EasybuyResponse;
import com.mr.zwt.easybuy.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName GoodController
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2019/12/20
 * @Version V1.0
 **/
@RestController
@RequestMapping(value = "good")
public class GoodController {
    @Autowired
    private GoodService service;
    @GetMapping
    private EasybuyResponse list(GoodEntity entity){

        return service.list(entity);
    }
    @PostMapping
    public EasybuyResponse save(@RequestBody GoodEntity entity){
        return service.save(entity);
    }

}
