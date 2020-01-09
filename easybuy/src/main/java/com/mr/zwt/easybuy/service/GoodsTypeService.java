package com.mr.zwt.easybuy.service;

import com.mr.zwt.easybuy.entity.GoodTypeEntity;
import com.mr.zwt.easybuy.response.EasybuyResponse;

public interface GoodsTypeService {
    EasybuyResponse list();

    EasybuyResponse save(GoodTypeEntity entity);
}
