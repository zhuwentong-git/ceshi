package com.mr.zwt.easybuy.controller;

import com.mr.zwt.easybuy.entity.GoodTypeEntity;
import com.mr.zwt.easybuy.response.EasybuyResponse;
import com.mr.zwt.easybuy.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName GoodsTypeController
 * @Description: TODO
 * @Author zhuwentong
 * @Date 2019/12/20
 * @Version V1.0
 **/
@RestController
@RequestMapping(value = "good_type")
public class GoodsTypeController {
    @Autowired
    private GoodsTypeService service;

    @GetMapping
    public EasybuyResponse list(){
        return service.list();
    }
    @PostMapping
    public EasybuyResponse save(@RequestBody GoodTypeEntity entity){
        return service.save(entity);
    }
}
