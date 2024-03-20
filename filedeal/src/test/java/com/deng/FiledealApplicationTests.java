package com.deng;

import com.deng.service.InfoTowerService;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.java2d.pipe.SpanIterator;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FiledealApplicationTests {

    @Autowired
    InfoTowerService towerService;

    @Test
    void contextLoads() {
        SimpleDateFormat ymdhms=new SimpleDateFormat("yyyyMMddHHmmss");
        Date start=new Date();
        System.out.println("-------start-------"+ymdhms.format(start));
        towerService.loadTower(null);
        Date end=new Date();
        System.out.println("-------end-------"+ymdhms.format(end));
        long time=(end.getTime()-start.getTime())/1000;
        System.out.println("程序耗时:"+time+"s");
    }

}
