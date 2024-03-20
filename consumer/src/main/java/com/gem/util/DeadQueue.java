package com.gem.util;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

/**
 * @Author：dengwenxin-wb
 * @Project：consumer
 * @name：DeadQueue
 * @Date：2024/3/11 15:49
 */
public class DeadQueue {

    //普通交换机
    private final static String EXCHANGE="exchange";
    //死信交换机
    private final static String DEAD_EXCHAGE="deadexchange";
    //普通队列
    private final static String QUEUE="queue";
    //死信队列
    private final static String DEAD_QUEUE="deadqueue";

    public static void main(String[] args) {
        try {
            dealMessage();
        }catch (Exception e){

        }
    }

    private static void dealMessage() throws IOException, TimeoutException {
        Channel channel = channel();
        //绑定交换机
        channel.exchangeDeclare(EXCHANGE,BuiltinExchangeType.DIRECT);
        //绑定死信交换机
        channel.exchangeDeclare(DEAD_EXCHAGE,BuiltinExchangeType.DIRECT);
        //声明普通队列，需要设置参数
        HashMap<String, Object> map = new HashMap<>();
        //过期时间(默认毫秒)---也可以在生产者那边设置时间
        map.put("x-message-ttl",10000);
        //正常队列消息过期后转发到死信交换机
        map.put("x-dead-letter-exchange",DEAD_QUEUE);
        //设置死信的routingkey
        map.put("x-dead-routing-key","list");
        channel.queueDeclare(QUEUE,false,false,false,map);

        //声明死信队列
        channel.queueDeclare(DEAD_QUEUE,false,false,false,new HashMap<>());
        //绑定队列
        channel.queueBind(QUEUE,EXCHANGE, "zzz");
        //绑定死信队列
        channel.queueBind(DEAD_QUEUE,DEAD_EXCHAGE,"list");
        System.out.println("等待接受消息--------");
        DeliverCallback deliverCallback=(String var1, Delivery var2)->{
            byte[] body = var2.getBody();
            String str=new String(body);
            System.out.println("DeadQueue接收到的消息:"+str);

        };
        CancelCallback cancelCallback= var1-> System.out.println(var1+"-----消费者取消消费回调");
        //自动应答true
        channel.basicConsume(QUEUE,true,deliverCallback,cancelCallback);


    }

    private static Channel channel() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        return channel;
    }

}
