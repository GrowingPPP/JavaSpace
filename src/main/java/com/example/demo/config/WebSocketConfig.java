package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /***
     * 注册 Stomp的终端，前缀为"/api/v1/socket"
     * addEndpoint：添加STOMP协议的端点。提供WebSocket或SockJS客户端访问的地址
     * withSockJS：使用SockJS协议
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/api/v1/socket")//stomp协议终端，前缀为"/api/v1/socket"
                .setAllowedOrigins("*")//允许跨域访问
                .withSockJS();//指定使用SockJS协议
    }
    /**
     * 配置消息代理
     * 启动Broker，消息的发送的地址符合配置的前缀来的消息才发送到这个broker
     */

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /**
         * 以"/api/v1/socket/send"开头的会被转发给消息代理（broker），由broker广播给连接的客户端
         */
        registry.enableSimpleBroker("/api/v1/socket/send");//推送消息前缀
        /**
         * message的destination 如果是以"/api/v1/socket/req"开头，则会转发给响应的消息处理方法（如使用@MessageMapping注解的方法）
         */
        registry.setApplicationDestinationPrefixes("/api/v1/socket/req");//应用请求前缀
        registry.setUserDestinationPrefix("/user");//推送用户前缀
    }
}
