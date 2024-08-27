package com.royal.rabbitmq.controller;

import com.royal.rabbitmq.config.RabbitMQConfig;
import com.royal.rabbitmq.entities.User;
import com.royal.utils.Response;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {

    @Autowired
    private AmqpTemplate rabbitMQTemplate;

    @GetMapping("/send-text")
    public Response<String> send(@RequestParam String message) {
        rabbitMQTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, RabbitMQConfig.ROUTING_KEY_1, message);
        return Response.success("RabbitMQ send message ok");
    }

    @GetMapping("/send-user")
    public Response<User> send(@RequestBody User user) {
        rabbitMQTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, RabbitMQConfig.ROUTING_KEY_2, user);
        return Response.success("RabbitMQ send message ok", user);
    }
}
