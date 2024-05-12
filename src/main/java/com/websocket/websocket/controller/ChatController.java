package com.websocket.websocket.controller;

import com.websocket.websocket.model.ChatMessage;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Timestamp;
import java.util.Date;
import java.util.Random;

@Controller

public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/message")
    public ChatMessage sendMessage(@Payload ChatMessage message) {
        Random rand = new Random();
        int counter = rand.nextInt(10000000);
        System.out.println(message);
        message.setTimestamp(new Date());
        message.setId(counter);
        return message;
    }
}
