package com.royalhek17.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class WebSocketApplication {

    private static final Logger log = LoggerFactory.getLogger(WebSocketApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);

        log.info("++++++++++++++++++++++++++++++++++++");
        log.info("[[ Start Spring Websocket Success ]]");
        log.info("++++++++++++++++++++++++++++++++++++");
    }
}
