package com.deng.service.Impl;

import com.deng.entity.InfoTower;
import com.deng.mapper.InfoTowerMapper;
import com.deng.service.InfoTowerService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.naming.Name;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：dengwenxin-wb
 * @Project：filedeal
 * @name：InfoTowerServiceImpl
 * @Date：2024/2/2 15:48
 */
@Service("infoTowerService")
public class InfoTowerServiceImpl extends Thread implements InfoTowerService {

    @Resource(name = "infoTowerMapper")
    InfoTowerMapper infoTowerMapper;

    private static String str1="这是测试中文";
    private static String str2="这是测试中文";

    @Override
    public void loadTower(List<InfoTower> lists) {
        System.out.println(str1);
        System.out.println(str2);
        List<String>str=new ArrayList<>();
        str.add("tower_id");
        str.add("tower_code");
        str.add("lng");
        str.add("lat");
        str.add("line_name");
        Map<String,Object> map=new HashMap<>();
        map.put("filepath","I:\\filedeal\\file\\info_tower_202402021546.csv");
        map.put("tableName","info_tower_1");
        map.put("line", File.separator);
        map.put("list",str);
        String filepath="I:\\filedeal\\file\\info_tower_202402021546.csv";
        String tableName="info_tower_1";
        String line="\r\n";
        infoTowerMapper.load(filepath,tableName,line,1,str);
//        infoTowerMapper.load(map);
        try {

        }catch (Throwable e){

            e.getCause();
        }finally {
            System.out.println("------------------------------------------");
        }
        hashCode();
    }


}
