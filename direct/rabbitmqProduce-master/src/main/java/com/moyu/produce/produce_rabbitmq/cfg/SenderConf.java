package com.moyu.produce.produce_rabbitmq.cfg;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SenderConf {
   // 采用的是Direct模式,需要在配置Queue的时候,指定一个键,使其和交换机绑定.
    @Bean
    public Queue queue(){
        return new Queue("myQueue");
    }
}
