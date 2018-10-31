package com.moyu.produce.produce_rabbitmq.send;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void send(){
        //param1  指定发送到某个队列,param2  发送的消息体
        rabbitTemplate.convertAndSend("myQueue","消费和生产同时在线 ---");
    }
}
