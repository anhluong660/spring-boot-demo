package com.royal.websocket.controller;

import com.royal.websocket.service.WebSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
public class WebSocketController extends TextWebSocketHandler {

    @Autowired
    private WebSocketService webSocketService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("New Connection: {}", session.getId());
        session.sendMessage(new TextMessage("Please tell me your name?"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        if (!webSocketService.hasName(session)) {
            webSocketService.setName(session, message.getPayload());
            session.sendMessage(new TextMessage("Hello " + message.getPayload()));
            return;
        }

        String name = webSocketService.getName(session);
        String content = message.getPayload();

        List<String> list = Arrays.asList(content.split(" "));
        Collections.reverse(list);
        String text = String.join(" ", list);
        String res = String.format("[Server]: %s", text);

        session.sendMessage(new TextMessage(res));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("[{}] is disconnect", webSocketService.getName(session));
        webSocketService.remove(session);
    }
}
