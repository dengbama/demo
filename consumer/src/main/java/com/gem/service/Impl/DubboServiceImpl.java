package com.gem.service.Impl;

import com.gem.dubbo.Zkservice;
import com.gem.service.DubboService;
//import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @Author：dengwenxin-wb
 * @Project：dubbotest
 * @name：DubboServiceImpl
 * @Date：2024/3/7 10:10
 */
@Service
public class DubboServiceImpl implements DubboService {

//    @DubboReference(
////            timeout = 3000,
////            retries = 3,
////            version = "*",
////            url = "127.0.0.1:23123",
//            loadbalance = "roundrobin",
//            cluster = "forking"
//    )
//    Zkservice zkservice;

    @Override
    public String testService() {
//        String ser = zkservice.ser();
//        System.out.println("-----------"+ser);
//        return ser;
        return null;
    }
}
