package com.wl.websocket;

import com.wl.websocket.utils.SpringBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

/**
 * @author wl
 * @date 2018/3/17.
 */

@Component
public class Clients extends AbstractWebSocket {

    private List<Object> listWebSocket;

    @Autowired
    private SpringBeanUtil springBeanUtil;

    private void init(){
        if (listWebSocket == null) {
            listWebSocket = springBeanUtil.getBeansByInterface(IWebSocket.class);
        }
    }

    @Override
    public void onOpen(WebSocketSession session) {
        init();
        for(Object obj : listWebSocket){
            IWebSocket webSocket = (IWebSocket)obj;
            webSocket.onOpen(session);
        }
    }

    @Override
    public void onClose(WebSocketSession session) {
        for(Object obj : listWebSocket){
            IWebSocket webSocket = (IWebSocket)obj;
            webSocket.onClose(session);
        }
    }

    @Override
    public void onMessage(WebSocketSession session, TextMessage message) {
        for(Object obj : listWebSocket){
            IWebSocket webSocket = (IWebSocket)obj;
            webSocket.onMessage(session, message);
        }
    }

    @Override
    public void onError(WebSocketSession session, Throwable exception) {
        for(Object obj : listWebSocket){
            IWebSocket webSocket = (IWebSocket)obj;
            webSocket.onError(session, exception);
        }
    }
}
