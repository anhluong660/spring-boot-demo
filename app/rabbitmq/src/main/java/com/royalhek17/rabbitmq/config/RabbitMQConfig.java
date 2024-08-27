package com.royalhek17.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String TOPIC_EXCHANGE = "TopicExchange";
    public static final String FAN_OUT_EXCHANGE = "FanOutExchange";

    public static final String ROUTING_KEY_1 = "Routing_Key_1";
    public static final String ROUTING_KEY_2 = "Routing_Key_2";
    public static final String ROUTING_KEY_3 = "Routing_Key_3";

    public static final String QUEUE_1 = "q1";
    public static final String QUEUE_2 = "q2";
    public static final String QUEUE_3 = "q3";

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE_1, false);
    }

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE_2, false);
    }

    @Bean
    public Queue queue3() {
        return new Queue(QUEUE_3, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FAN_OUT_EXCHANGE);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with(ROUTING_KEY_1);
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with(ROUTING_KEY_2);
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queue3()).to(topicExchange()).with(ROUTING_KEY_3);
    }

    @Bean
    public Binding broadcast1() {
        return BindingBuilder.bind(queue1()).to(fanoutExchange());
    }

    @Bean
    public Binding broadcast2() {
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }

    @Bean
    public Binding broadcast3() {
        return BindingBuilder.bind(queue3()).to(fanoutExchange());
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
