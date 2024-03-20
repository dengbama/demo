package com.gem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：dengwenxin-wb
 * @Project：consumer
 * @name：DubboService
 * @Date：2024/3/7 16:55
 */
@RestController
@RequestMapping("/test")
public class DubboService {

    @Autowired
    com.gem.service.DubboService dubboService;

    @RequestMapping("/test1")
    public String getstr(){
        return dubboService.testService();
    }

}
