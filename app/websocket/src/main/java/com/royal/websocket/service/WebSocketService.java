package com.royal.websocket.service;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebSocketService {
    private final Map<WebSocketSession, String> sessions = new HashMap<>();

    public boolean hasName(WebSocketSession session) {
        return sessions.containsKey(session);
    }

    public String getName(WebSocketSession session) {
        return sessions.getOrDefault(session, "No Name");
    }

    public void setName(WebSocketSession session, String name) {
        sessions.put(session, name);
    }

    public void remove(WebSocketSession session) {
        sessions.remove(session);
    }
}
