package com.moyu.consumer.consumer_rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @RabbitListener 注解定义该类对hello队列的监听
 */
@Component
public class Receiver {

    @RabbitListener(queues="topic.ms")    //监听器监听指定的Queue
    public void process1(String str) {
        System.out.println("topic.ms接收到新的消息 : " + str);
    }
    @RabbitListener(queues="topic.message")    //监听器监听指定的Queue
    public void process2(String str) {
        System.out.println("topic.message接收到新的消息 : " + str);
    }

}
