package com.wl.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * 对外提供的接口，用户只要实现该接口即可
 *
 * @author wl
 * @date 2018/3/19.
 */
public interface IWebSocket {
    /**
     * open
     */
    void onOpen(WebSocketSession session);

    /**
     * close
     */
    void onClose(WebSocketSession session);

    void onMessage(WebSocketSession session, TextMessage message);

    void sendMessage(WebSocketSession session, TextMessage message) throws IOException;

    void onError(WebSocketSession session, Throwable exception);
}
