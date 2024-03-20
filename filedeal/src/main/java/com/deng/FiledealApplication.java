package com.deng;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.deng.mapper")
@EnableTransactionManagement
@EnableAsync

//@EnableDubbo
//@DubboComponentScan("com.deng.config.MyDubboConfig")
public class FiledealApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiledealApplication.class, args);
    }

}
