package com.royalhek17.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApplication.class, args);

        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println("[[ Start Spring RabbitMQ Success ]]");
        System.out.println("+++++++++++++++++++++++++++++++++++");
    }
}
