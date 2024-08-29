package com.royalhek17.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaApplication {

    private static final Logger log = LoggerFactory.getLogger(KafkaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);

        log.info("++++++++++++++++++++++++++++++++");
        log.info("[[ Start Spring Kafka Success ]]");
        log.info("++++++++++++++++++++++++++++++++");
    }
}
