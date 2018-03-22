package com.wl.websocket;


import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * @author wl
 * @date 2018/3/19.
 */
public abstract class AbstractWebSocket implements IWebSocket {

    @Override
    public void sendMessage(WebSocketSession session, TextMessage message) throws IOException {
        session.sendMessage(message);
    }
}
