package com.royalhek17.kafka.service;

import com.royalhek17.kafka.config.KafkaConfig;
import com.royalhek17.kafka.entities.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaService {

    @KafkaListener(topics = KafkaConfig.SAMPLE_TOPIC)
    public void listenTextMessage(String message) {
        log.info("Kafka listen message: {}", message);
    }

    @KafkaListener(topics = KafkaConfig.OBJECT_TOPIC)
    public void listenMessage(User user) {
        log.info("Kafka Receive Object: {}", user);
    }
}
