package com.royalhek17.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);

        System.out.println("++++++++++++++++++++++++++++++++");
        System.out.println("[[ Start Spring Kafka Success ]]");
        System.out.println("++++++++++++++++++++++++++++++++");
    }
}
