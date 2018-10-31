package com.moyu.produce.produce_rabbitmq.cfg;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicSenderConfig {

    //配置队列
    @Bean(name = "queueMessage")
    public Queue queue_message() {
        return new Queue("topic.message");
    }

    //配置第二个队列
    @Bean(name = "queueMs")
    public Queue queue_ms() {
        return new Queue("topic.ms");
    }

    //配置交换机
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("myExchange");
    }
    // 将队列按照相应的规则绑定到交换机上

    @Bean
    public Binding bindingExchangeMessage(@Qualifier("queueMessage") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    public Binding bindingExchangeMessages(@Qualifier("queueMs") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
        //*表示一个词,#表示零个或多个词
    }
}
