package com.deng.util;



import com.rabbitmq.client.*;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeoutException;

/**
 * @Author：dengwenxin-wb
 * @Project：filedeal
 * @name：Quereutil
 * @Date：2024/3/9 10:13
 */
public class Quereutil extends Thread {

    private final static String EXCHANGES_NAME="exchange";

    public static void main(String[] args) {
//        普通
//        Quereutil quereutil=new Quereutil();
//        quereutil.start();
        try {
//            publishMessageAsync();
            exange();
        }catch (Exception e){

        }

    }

    public static void exange()throws  Exception{
        Channel channel = channel();
        //死信消息设置ttl时间
        AMQP.BasicProperties properties=new AMQP.BasicProperties()
                .builder().expiration("10000").build();

        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            //发消息
            String message=scanner.next();
            //发送到哪个交换机
            //路由的key值是哪个
            //消息是否持久化(设置参数)
            //发送的消息体
            channel.basicPublish(EXCHANGES_NAME,"zzz",
                    properties,message.getBytes());
            System.out.println("发送完成"+message);
        }
    }

    private static Channel channel() throws IOException, TimeoutException {
        //创建rabbitmq工厂
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        //创建连接
        Connection connection = factory.newConnection();
        //获取信道(这一步才是发消息的)
        return connection.createChannel();
    }

    private static void send(Channel channel) throws IOException, TimeoutException, InterruptedException {
        channel.confirmSelect();
        Map<String, Object> map=new HashMap<>();
        //创建一个队列(声明一个队列)
        //队列名称
        // 持久化(队列是否保存)-默认存储在内存中-默认不持久
        // 排他(该队列是否只供一个消费者消费，是否进行消息共享)true表示可以多个消费者消费，默认不允许多个消费者消费
        // 是否自动删除(最后一个消费者端开链接后该队列是否自动删除)true表示自动删除
        // 其他参数
        boolean durable=true;
        channel.queueDeclare("quere_name_"+ 1,durable,false,false,map);
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            //发消息
            String message=scanner.next();;
            //发送到哪个交换机
            //路由的key值是哪个(队列名称)
            //消息是否持久化
            //发送的消息体
            AMQP.BasicProperties basicProperties= MessageProperties.PERSISTENT_TEXT_PLAIN;
            channel.basicPublish("","quere_name_"+ 1, basicProperties,message.getBytes());
            boolean b = channel.waitForConfirms();
            if (b){
                System.out.println("消息发送完成---"+message);
            }else {
                System.out.println("消息发送失败---"+message);
            }
        }
    }



    public static void publishMessageAsync() throws Exception{
        Channel channel = channel();
//        String queue = channel.queueDeclare().getQueue();
        String uuid = UUID.randomUUID().toString();
        //队列声明
        channel.queueDeclare(uuid,true,false,false,new HashMap<>());
        //开启消息发布
        channel.confirmSelect();
        //线程有序的hash表，适用于高并发的情况下
        //将序号和消息进行关联
        //可以批量删除消息
        //支持高并发
        ConcurrentSkipListMap<Long,String>map=new ConcurrentSkipListMap<>();
        //消息确认成功回调函数(long消息的标识,boolen是否为批量确认)
        ConfirmCallback success=(long long_,boolean b)-> {
            //删除已经拿到的消息
            if (b){
                //批量删除
                ConcurrentNavigableMap<Long, String> confiremed =
                        map.headMap(long_);
                confiremed.clear();
            }else {
                //单个删除
                map.remove(long_);
            }
            System.out.println("确认的消息"+long_);
        };
        //消息确认失败回调函数
        ConfirmCallback fail=(long long_,boolean b)-> {
            String s = map.get(long_);
            System.out.println("未确认的消息"+s);
        };
        //准备监听器，监听哪个消息成功哪个失败
        //一个参数的是监听成功的
        //两个参数的是可以同时监听成功和失败的(不监听可以设置null)
        channel.addConfirmListener(success,fail);//异步操作
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            String message=""+i;
            //发布消息
            channel.basicPublish("",uuid,MessageProperties.PERSISTENT_TEXT_PLAIN,
                    message.getBytes());
            //记录要发送的消息
            map.put(channel.getNextPublishSeqNo(),message);
        }
        long end = System.currentTimeMillis();
        System.out.println(
                "消息发送时间:"+(end-start)+"ms"
        );
    }

    @Override
    public void run(){
        try {
            Channel lian = channel();
            send(lian);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
