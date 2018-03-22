package com.wl.websocket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by wl on 2018/3/20.
 */
public class WsHandler extends TextWebSocketHandler {

    @Autowired
    Clients clients;

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception
    {

        super.afterConnectionClosed(session, status);
        System.out.println("close....");
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception
    {
        super.afterConnectionEstablished(session);
        System.out.println("new connection");
        if(clients != null){
            clients.onOpen(session);
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception
    {
        System.out.println(message.getPayload());
        TextMessage msg=new TextMessage(message.getPayload());
        if(clients != null){
            clients.onMessage(session, message);
        }
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception
    {
        super.handleMessage(session, message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception
    {
        super.handleTransportError(session, exception);
        if(clients != null){
            clients.onError(session, exception);
        }
    }
}
