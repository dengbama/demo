package com.gem.service.Impl;

import com.gem.dubbo.Zkservice;
import com.gem.service.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author：dengwenxin-wb
 * @Project：dubbotest
 * @name：DubboServiceImpl
 * @Date：2024/3/7 10:10
 */
public class DubboServiceImpl implements DubboService {

    @Autowired
    Zkservice zkservice;

    @Override
    public String testService() {
        String ser = zkservice.ser();
        System.out.println("-----------"+ser);
        return "testservie";
    }
}
