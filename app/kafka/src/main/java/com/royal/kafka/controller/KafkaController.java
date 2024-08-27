package com.royal.kafka.controller;

import com.royal.kafka.config.KafkaConfig;
import com.royal.utils.Response;
import com.royal.kafka.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, User> kafkaUserTemplate;

    @GetMapping("/send-text")
    public Response<String> send(@RequestParam String message) {
        kafkaTemplate.send(KafkaConfig.SAMPLE_TOPIC, message);
        return Response.success("kafka send text ok");
    }

    @GetMapping("/send-user")
    public Response<User> send(@RequestBody User user) {
        kafkaUserTemplate.send(KafkaConfig.OBJECT_TOPIC, user);
        return Response.success("kafka send user ok", user);
    }
}
