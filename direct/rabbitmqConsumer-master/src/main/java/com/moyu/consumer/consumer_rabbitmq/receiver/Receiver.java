package com.moyu.consumer.consumer_rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @RabbitListener 注解定义该类对hello队列的监听
 */
@Component
@RabbitListener(queues = "myQueue")
public class Receiver {
    /**
     * @RabbitHandler 注解来指定对消息的处理方法
     * @param hello
     */
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver接收到新的消息 : " + hello);
    }
}
