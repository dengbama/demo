package com.hyj.player.redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @Author：dengwenxin-wb
 * @Project：player
 * @name：RedisUtil
 * @Date：2024/2/27 17:45
 */
public class RedisUtil {

    public static void main(String[] args) {
        Jedis redis = new Jedis("127.0.0.1", 6379);
//        Set<String> keys = redis.keys("*");
//        List<String>stringList=new ArrayList<>(keys);
//        for(String str:stringList){
//            System.out.println(str);
//        }
        Transaction multi = redis.multi();
        multi.watch("");
        try {
            List<Object> exec = multi.exec();
        } catch (Exception e) {
            multi.unwatch();
            multi.discard();
        } finally {
            multi.unwatch();
            multi.close();
        }


        redis.watch("");
        redis.unwatch();
    }

    public static void readFile() {
        File file = new File("I:\\redis\\数据\\全国json\\全国json.txt");

    }

}
