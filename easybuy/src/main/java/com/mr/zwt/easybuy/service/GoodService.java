package com.mr.zwt.easybuy.service;

import com.mr.zwt.easybuy.entity.GoodEntity;
import com.mr.zwt.easybuy.response.EasybuyResponse;

public interface GoodService {
    EasybuyResponse list(GoodEntity entity);

    EasybuyResponse save(GoodEntity entity);
}
