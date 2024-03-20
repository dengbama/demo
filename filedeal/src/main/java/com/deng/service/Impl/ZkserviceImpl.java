package com.deng.service.Impl;

import com.deng.service.Zkservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author：dengwenxin-wb
 * @Project：filedeal
 * @name：ZkserviceImpl
 * @Date：2024/3/6 15:21
 */
@Service
//@DubboService
public class ZkserviceImpl implements Zkservice {

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public String ser() {
        System.out.println("----------------------------");
        System.out.println("开始调用服务");
        return "服务调用完成";
    }

}
