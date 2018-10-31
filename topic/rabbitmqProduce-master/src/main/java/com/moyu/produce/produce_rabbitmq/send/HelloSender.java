package com.moyu.produce.produce_rabbitmq.send;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void send(){
        //参数分别表示  ： 交换机exchange名称 ，发送的key, 发送的内容
        rabbitTemplate.convertAndSend("myExchange","topic.message","hello , i am rabbitmq ! ! !  ");
        System.out.println("success");
    }
}
