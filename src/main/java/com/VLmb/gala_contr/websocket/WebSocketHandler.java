package com.VLmb.gala_contr.websocket;

import com.VLmb.gala_contr.repository.ParcelRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private final List<WebSocketSession> sessionList = new ArrayList<>();
    @NotNull
    private final ParcelRepository parcelRepository;

    public List<WebSocketSession> getSessionList() {
        return sessionList;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Когда новый браузер подключается, добавляем его сессию в список
        sessionList.add(session);
        System.out.println("WebSocket-session has opened: " + session.getId());
    }

    public void sendMessage(String message) {
        for (WebSocketSession session : sessionList) {
            try {
                if (session.isOpen()) {
                    session.sendMessage(new TextMessage(message));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Когда браузер отключается, удаляем его сессию из списка
        sessionList.remove(session);
        System.out.println("WebSocket-session has closed: " + session.getId());
    }
}
