package com.wl.websocket.config;

import com.wl.websocket.WsHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by wl on 2018/3/20.
 */

@Configuration
@EnableWebSocket
public class WsConfigure implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(myHandler(), "/websocket").setAllowedOrigins("*");
    }

    @Bean
    public WsHandler myHandler(){
        return new WsHandler();
    }
}
