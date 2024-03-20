package com.deng.service.Impl;

import com.deng.service.RabbitmqTestService;
import com.deng.util.Quereutil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @Author：dengwenxin-wb
 * @Project：filedeal
 * @name：RabbitmqTestServiceImpl
 * @Date：2024/3/8 16:49
 */
@Service
public class RabbitmqTestServiceImpl  implements RabbitmqTestService {

    private static String quere_name="rabbitmq_one";

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public RabbitmqTestServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public List<String> testservice() {

        return null;
    }

    public static void main(String[] args) {
        try {
            send();
        }catch (Exception e){

        }

    }

    public static void send() throws IOException, TimeoutException {
        //创建rabbitmq工厂
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        //创建连接
        Connection connection = factory.newConnection();
        //获取信道(这一步才是发消息的)
        Channel channel = connection.createChannel();
        Map<String, Object>map=new HashMap<>();
        //创建一个队列(声明一个队列)
        //队列名称
        // 持久化(队列里面的消息是否保存)-默认存储在内存中-默认不持久
        // 排他(该队列是否只供一个消费者消费，是否进行消息共享)true表示可以多个消费者消费，默认不允许多个消费者消费
        // 是否自动删除(最后一个消费者端开链接后该队列是否自动删除)true表示自动删除
        // 其他参数
        channel.queueDeclare(quere_name,false,false,false,map);
        //发消息
        String message="This is a rabbitmq_message";
        //发送到哪个交换机
        //路由的key值是哪个
        //其他参数信息
        //发送的消息体
        channel.basicPublish("",quere_name,null,message.getBytes());
        System.out.println("消息发送完成");
    }

}
