package com.example.demo.controller;


import com.example.demo.model.RequestMessage;
import com.example.demo.model.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class WebSocketController {

    @Resource
    private SimpMessagingTemplate messagingTemplate ;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @MessageMapping("/welcome")
    public ResponseMessage toTopic(RequestMessage msg) throws Exception
    {
        System.out.println("======================"+msg.getMessage());
        this.messagingTemplate.convertAndSend("/api/v1/socket/send",msg.getMessage());
        return new ResponseMessage("欢迎使用webScoket："+msg.getMessage());
    }

    @MessageMapping("/message")
    public ResponseMessage toUser(RequestMessage msg ) {
        System.out.println(msg.getMessage());
        this.messagingTemplate.convertAndSendToUser("123","/message",msg.getMessage());
        return new ResponseMessage("欢迎使用webScoket："+msg.getMessage());
    }
}