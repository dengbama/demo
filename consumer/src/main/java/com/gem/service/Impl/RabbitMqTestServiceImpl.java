package com.gem.service.Impl;

import com.gem.service.RabbitMqTestService;
import com.rabbitmq.client.*;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author：dengwenxin-wb
 * @Project：consumer
 * @name：RabbitMqTestServiceImpl
 * @Date：2024/3/8 17:15
 */
@Service
public class RabbitMqTestServiceImpl implements RabbitMqTestService {

    private static String quere_name="rabbitmq_one";

    public static void main(String[] args) {
        try {
            consumer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void consumer() throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //消费者接收消息
        //消费哪个队列
        // 消费成功成功之后是否自动答复(ture代表自动答复)
        // 消费者未成功消费的回调
        // 消费者取消消费回调
        DeliverCallback deliverCallback=(String var1, Delivery var2)->{
            byte[] body = var2.getBody();
            String str=new String(body);
            System.out.println(str);
        };
        CancelCallback cancelCallback=var1->{
            System.out.println("消费消息被中断");
        };
        channel.basicConsume(quere_name,true,deliverCallback,cancelCallback);

    }













}
