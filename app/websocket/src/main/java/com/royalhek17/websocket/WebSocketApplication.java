package com.royalhek17.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class WebSocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);

        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("[[ Start Spring Websocket Success ]]");
        System.out.println("++++++++++++++++++++++++++++++++++++");
    }
}
