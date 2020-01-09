package com.mr.zwt.easybuy.service;

import com.mr.zwt.easybuy.response.EasybuyResponse;
import com.mr.zwt.easybuy.vo.GoodCarVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface GoodCarService {
    EasybuyResponse save(Map<String, List<GoodCarVO>> goodCar, HttpServletRequest request);

    EasybuyResponse list(HttpServletRequest request);
}
