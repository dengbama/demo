package com.deng.service;

import com.deng.FiledealApplication;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author：dengwenxin-wb
 * @Project：filedeal
 * @name：InfoTowerTest
 * @Date：2024/2/2 17:09
 */
@SpringBootTest(classes = FiledealApplication.class)
@RunWith(SpringRunner.class)
public class InfoTowerTest {
    @Resource(name = "infoTowerService")
    InfoTowerService towerService;

    @Test
    public void testInfoTower(){
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
