package com.royalhek17.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitMQApplication {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApplication.class, args);

        log.info("+++++++++++++++++++++++++++++++++++");
        log.info("[[ Start Spring RabbitMQ Success ]]");
        log.info("+++++++++++++++++++++++++++++++++++");
    }
}
