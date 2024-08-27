package com.royalhek17.rabbitmq.service;

import com.royalhek17.rabbitmq.config.RabbitMQConfig;
import com.royalhek17.rabbitmq.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitService {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_1)
    public void listenMessageQueue1(String message) {
        log.info("Queue 1: listen message: {}", message);
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_2)
    public void listenMessageQueue2(User user) {
        log.info("Queue 2: listen message: {}", user);
    }
}
