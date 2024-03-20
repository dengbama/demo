package com.gem.util;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author：dengwenxin-wb
 * @Project：consumer
 * @name：Quereutil1
 * @Date：2024/3/9 17:29
 */
public class Quereutil1 extends Thread {

    private final static String EXCHANGES_NAME="topic_log";

    private String a;

    public static void main(String[] args) {

        Quereutil1 quereutil=new Quereutil1("线程1");
        quereutil.start();

    }

    private void consumer(Channel channel) throws IOException {
        channel.exchangeDeclare(EXCHANGES_NAME, BuiltinExchangeType.TOPIC);
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue,EXCHANGES_NAME,"lazy.#");
        //消费者接收消息
        //消费哪个队列
        // 消费成功成功之后是否自动答复(ture代表自动答复)
        // 消费者未成功消费的回调
        // 消费者取消消费回调
        DeliverCallback deliverCallback=(String var1, Delivery var2)->{
            byte[] body = var2.getBody();
            String str=new String(body);
            System.out.println(this.a+"---接收到的消息:"+str+",routingkey:"+var2.getEnvelope().getRoutingKey());
            //消息手动应答
            //消息标记tag(每个消息的唯一标识)
            //自动应答是否自动处理
            channel.basicAck(var2.getEnvelope().getDeliveryTag(),false);
        };
        CancelCallback cancelCallback= var1->{
            System.out.println(var1+"-----消费者取消消费回调");
        };
        System.out.println(this.a+"---");
//        channel.basicQos(5);
        //开启手动应答
        boolean chackack=false;
        channel.basicConsume(queue,chackack,deliverCallback,cancelCallback);
    }

    @Override
    public void run(){
        try {
            Channel lian = channel();
            consumer(lian);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Quereutil1(String a) {
        this.a = a;
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
        //获取信道(这一步才是发消息或者是获取消息)
        return connection.createChannel();
    }

}
