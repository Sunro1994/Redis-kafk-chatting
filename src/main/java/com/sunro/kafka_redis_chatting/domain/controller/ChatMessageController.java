package com.sunro.kafka_redis_chatting.domain.controller;

import com.sunro.kafka_redis_chatting.domain.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;


@RequiredArgsConstructor
@Controller
public class ChatMessageController {
    private final KafkaTemplate<String, ChatMessage> kafkaTemplate;
    private final NewTopic topic;

    @MessageMapping("/chat/message")
    public void mssage(ChatMessage chatMessage) {
        if (ChatMessage.MessageType.ENTER.equals(chatMessage.getType())) {
            chatMessage.setMessage(chatMessage.getSender()+"님 등장!");
        }
        kafkaTemplate.send(topic.name(), chatMessage);
    }
}
